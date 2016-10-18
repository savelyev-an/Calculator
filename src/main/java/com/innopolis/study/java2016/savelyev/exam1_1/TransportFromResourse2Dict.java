package com.innopolis.study.java2016.savelyev.exam1_1;

import java.io.*;

/**  поток-трубопровод с функциями контроля ошибки:
 * 	 возможность открытия файла,
 *	 отлов не русских символов,
 * 	 запись в MyDict получаемых строк
 *	 контроль isInterrapted;
 */

//http://stackoverflow.com/questions/6932369/inputstream-from-a-url

public class TransportFromResourse2Dict extends Thread{
	SpecialFileReader curReader;
	ConcurrentHashMapRate<String> dict;

	TransportFromResourse2Dict(ConcurrentHashMapRate<String> dict, String fileName) {
		this.dict=dict;
		// Здесь мы должны выбрать, какого ридера выбираем
		try {
			this.curReader = new SpecialFileReader (fileName);
		} catch (FileNotFoundException e) {
			System.out.println( "Файл "+fileName+ " не найден !");
			System.out.println("Exception: " + e.toString());
		}
	}

	public void run () {
//		int state =0;
		String curWord="";
		char nextChr;
		while (curReader.hasNextChar()  && !isInterrupted()) {
			nextChr=curReader.nextChar();
//			System.out.println("Следующий символ =>" +nextChr+"<= является русской буквой ?"+ isRussianChar(nextChr) +" Текущее слово= "+curWord);
			if (isRussianChar(nextChr)) {
//				state=1;
				curWord=curWord+nextChr;
			} else {
				if (curWord.length()>0) {
					System.out.println("Помещаю в словарь слово: " + curWord);
					dict.put(curWord);
					curWord="";
				}
//				state = 0;
			}
		}
	}

	boolean isRussianChar (char chr){
		return (('А'<=chr) && (chr<= 'Я')) ||((  'а' <=chr) && (chr<= 'я'));
	}
}

interface SpecReadable {// extends Readable {
	public char nextChar();
	public boolean hasNextChar();
	public String getName();
}

class SpecialFileReader implements SpecReadable {
	private String fileName;
	FileReader reader;
	private int nextChar;
	private boolean hasNext;

	SpecialFileReader(String  fileName) throws FileNotFoundException {
		this.fileName= fileName;
		this.reader = new FileReader(fileName);
		nextChar='*';
		char Temp=this.nextChar();
		System.out.println(nextChar+" "+hasNext);
	}

	public char nextChar () {
		char temp = (char)nextChar;
		try {
			nextChar = reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		hasNext = (nextChar != -1);
		return temp;
	}

	public boolean hasNextChar (){return this.hasNext;}

	public String getName (){return this.fileName;}
}
