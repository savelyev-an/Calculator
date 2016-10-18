package com.innopolis.study.java2016.savelyev.exam_1_3;

import jdk.nashorn.api.scripting.URLReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;



/**
 * Класс многопоточной обработки данных, получаемых из ресурсов типа File и URL
 * Результат выполнения метода start() или run() - помещение информации о частоте русскиъх слов, прочитанных
 * из переданного на обработку ресурса, в частотный словарь  (ConcurrentHashMapRate<String> mapWordsRate)
 * В конструктор передаются
 * @param nameThread - имя потока типа String (используется для отладки и информирования о работе программы)
 * @param groupthread - группа, к которой принадлежит данный поток, используется для синхроного interrupt
 *                    в случае ошибки данных в каком либо из потоков
 * @param resourseName - имя ресурса из которго данный поток получает данные
 * @param mapWordsRate - словарь подсчета частоты появления русских слов
 * @param globalException - ссылка на ExceptionBox - куда должна быть помещена информация об ошибке,
 *                        в случае её перехвата или генерации
 * Created by User on 10.10.2016.
 */
public class ProceedingResourse extends Thread {
	private String resourseName;
	private ConcurrentHashMapRate<String> mapWordsRate;
	private ExceptionWraper globalException;

	private static Logger logger = LoggerFactory.getLogger (ProceedingResourse.class);

	/**
	 * Конструктор потока, описание полей см. в описании класса
	 * @param nameThread
	 * @param groupthread
	 * @param resourseName
	 * @param mapWordsRate
	 * @param globalException
	 */
	public ProceedingResourse(String nameThread,ThreadGroup groupthread,
							  String resourseName, ConcurrentHashMapRate<String> mapWordsRate,
							  ExceptionWraper globalException) {
		super (groupthread, nameThread);
		this.resourseName = resourseName;
		this.mapWordsRate = mapWordsRate;
		this.globalException = globalException;
		logger.info( " {} принят на обработку ресурс {}", this.getName(), this.resourseName);
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
						resourseName, "ошибка доступа: " + resourseName + " не существует", e1);
			}
		}
		return reader;
	}

	public void run () {
		logger.debug (" {} начата обработка ресурса {} ", this.getName(), resourseName );
		try (	Reader reader = setReader(resourseName) ) {
			Scanner scanner=new Scanner(reader);
			int lines=0;
			while (!isInterrupted() && scanner.hasNextLine()) {
				lines++;
				String line=scanner.nextLine();
				logger.trace("прочитана строка {}", line);
				String[] words = StringAndWordsProcessor.getWordsFromString(line);
				for(String word:words) {
					if (StringAndWordsProcessor.isRussian(word)) 	{mapWordsRate.put(word);
						logger.trace(" слово {} помещено в основной словарь", word);
					} else { throw new ForeignWordException(this.getName(), resourseName, this.getName()+
							" Прочитан иностранный символ из ресурса " + resourseName + "строка № " + lines);
					}
				}
			}
			if (globalException.getValue()==null) {
				logger.info (" {} Ресурс {}  успешно обработан, {} строк прочитано", this.getName(), resourseName, lines );
			} else logger.info ("{} прекратил работу в связи с ошибкой в параллельном потоке обработки", this.getName());
		} catch (OpenResourseException e) {
			logger.info (" {} ресурс {} недоступен, работа потока прервана" ,this.getName(), resourseName);
			SetGlobalExceptionAndInterruptGroup(e);
		} catch (ForeignWordException e) {
			logger.info (" {} Обработка ресурса {} прервана в связи с недопустимым символом в ресурсе", this.getName(),resourseName );
			SetGlobalExceptionAndInterruptGroup(e);
		} catch (IOException e) {
			logger.info (" {} Ошибка чтения  из ресурса {} ",this.getName(),resourseName);
			SetGlobalExceptionAndInterruptGroup(new ForeignWordException(this.getName(),
					resourseName, this.getName()+" Ошибка чтения из ресурса "+resourseName, e));
		}
	}

	private void SetGlobalExceptionAndInterruptGroup(Exception e){
		globalException.setValue(e);
		this.getThreadGroup().interrupt();
	}
}


