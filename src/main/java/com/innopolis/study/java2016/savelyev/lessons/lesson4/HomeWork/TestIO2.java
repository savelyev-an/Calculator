package com.innopolis.study.java2016.savelyev.test.lessons.lesson4.HomeWork;

import java.io.*;

/**
 * Created by User on 06.10.2016.
 */
public class TestIO2 {



	public static void main(String[] args) {

		try(FileReader reader = new FileReader(".\\Source.txt")) //"con"))//(
		{
			// читаем посимвольно
			int c; char chr;
			while((c=reader.read())!=-1){
				//chr=(char)c;
				System.out.print((char)c);
			}
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
}
