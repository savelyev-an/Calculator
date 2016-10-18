package com.innopolis.study.java2016.savelyev.exam1_2;

import jdk.nashorn.api.scripting.URLReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by User on 10.10.2016.
 */
public class ProceedingResourse extends Thread {
	private String resourseName;
	private ConcurrentHashMapRate<String> mapWordsRate;
	private BoxException globalException;

	private int nextChar;
	private boolean hasNext;

	public ProceedingResourse(String resourseName, ConcurrentHashMapRate<String> mapWordsRate, BoxException globalException) {
		this.resourseName = resourseName;
		this.mapWordsRate = mapWordsRate;
		this.globalException = globalException;
		System.out.println(this.getName()+" принят на обработку ресурс "+ this.resourseName);
		this.start();
	}

	private Reader setReader (String resourseName) throws OpenResourseException {
		Reader reader=null;
		try {
			reader = new URLReader(new URL(resourseName));
		} catch (MalformedURLException e) {
			try {
				reader = new FileReader(resourseName);
			} catch (FileNotFoundException e1) {
				throw new OpenResourseException(this.getName(),
						resourseName, "ошибка доступа: "+resourseName+ " не существует", e1);
			}
		}
		return reader;
	}

	public void run () {
		ConcurrentHashMapRate <String> curentMapWordsRate= new ConcurrentHashMapRate<>();
		String curWord="";
		String lastTenChars="          ";
		char nextChr=' ';
		try (	Reader reader = setReader(resourseName)) {
			nextChar='*';
			char Temp=this.nextChar(reader);
			while (!isInterrupted() && globalException.getValue()==null && this.hasNextChar()) {
				lastTenChars = lastTenChars.substring(1, 10) + nextChr;
				nextChr = this.nextChar(reader);
				if (isRussianChar(nextChr)) curWord = curWord + nextChr;
				if (isForeignChar(nextChr))
					throw new ForeignWordException(this.getName(), resourseName,
							this.getName()+" Иностранный символ '" + nextChr + "' прочитан из ресурса "
							+ resourseName + "Последение корректно прочитанные символы: " + lastTenChars);
				if ((!isRussianChar(nextChr) || !hasNextChar())&& curWord.length() > 0)  {
						System.out.println(this.getName()+" Помещаю во временный словарь слово: " + curWord);
						curentMapWordsRate.put(curWord);
						curWord = "";
					}
			}
			if (globalException.getValue()==null) {
				System.out.println(this.getName() + " Ресурс " + resourseName + " Обработан, " + curentMapWordsRate.getSize()
						+ " слов(а) добавляется в основной частотный словарь");
				mapWordsRate.add(curentMapWordsRate);
			} else System.out.println(this.getName()+" прекратил работу в связи с ошибкой в параллельном потоке обработки");

		} catch (IOException e) {
			System.out.println(this.getName()+" Ошибка чтения  из ресурса "+resourseName);
			globalException.setValue(new ForeignWordException  (this.getName(),
					resourseName, this.getName()+" Ошибка чтения из ресурса "+resourseName, e));

		} catch (OpenResourseException e) {
			System.out.println(this.getName()+" ресурс " + resourseName +" недосьтупен, работа потока прервана");
			System.out.println(e.getMessage());
			globalException.setValue(e);
		} catch (ForeignWordException e) {
			System.out.println(this.getName()+" Обработка ресурса " + resourseName +" прервана в связи с недопустимым символом в ресурсе");
			System.out.println(e.getMessage());
			globalException.setValue(e);
		}
	}

	boolean isRussianChar (char chr){
		return (('А'<=chr) && (chr<= 'Я')) ||((  'а' <=chr) && (chr<= 'я'));
	}

	boolean isForeignChar (char chr) {
		return (('A'<=chr) && (chr<= 'Z')) ||((  'a' <=chr) && (chr<= 'z'));
	}

	private char nextChar (Reader reader) throws IOException {
		char temp = (char)nextChar;
		nextChar = reader.read();
		hasNext = (nextChar != -1);
		return temp;
	}

	private boolean hasNextChar (){return this.hasNext;}
}

class ForeignWordException extends Exception {
	private String threadName;
	private String resourseName;

	public ForeignWordException(){super();}

	public ForeignWordException(String threadName, String resourseName, String message,  Exception e) {
		super(message, e);
		this.threadName = threadName;
		this.resourseName = resourseName;
	}

	public ForeignWordException(String threadName, String resourseName, String message) {
		super(message);
		this.threadName = threadName;
		this.resourseName = resourseName;
	}

	public void printStackTrace(){
		System.out.println("Ошибка содержимого данных");
		System.out.println("Сгенерирована потоком: "+threadName);
		System.out.println("Ресурс: "+ resourseName);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		super.printStackTrace();
	}
}

class OpenResourseException extends ForeignWordException {

	public OpenResourseException(String threadName, String resourseName, String message) {
		super(threadName, resourseName, message);
	}

	public OpenResourseException(String threadName, String resourseName, String message, Exception e) {
		super(threadName, resourseName, message, e);
	}
}