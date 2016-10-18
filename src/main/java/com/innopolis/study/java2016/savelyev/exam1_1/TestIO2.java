package com.innopolis.study.java2016.savelyev.exam1_1;

import java.io.*;

/**
 * Created by User on 10.10.2016.
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
		System.out.println("--------------------------");
//		try {
//			FileInputStream qwe = new FileInputStream(".\\Source.txt");
//			Reader scanner = new FileReader(qwe);
//			while (scanner.) {
//				System.out.println(scanner.nextInt());
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}