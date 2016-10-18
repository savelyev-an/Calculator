package com.innopolis.study.java2016.savelyev.lessons.Lesson7;

import java.util.Scanner;

/**
 * Created by User on 11.10.2016.
 */
public class ProbaScanerCon {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.println("Вводим 5 целых");
		int []  array= new int[5];
		for (int i=0 ; i<5;i++)
			array[i]=in.nextInt();
		System.out.println(" Вывод:");
		for (int i=0 ; i<5;i++)
			System.out.print(array[i]+" ");
		System.out.println();
		System.out.println();

		System.out.println("Вводим строку");
		String string = new String();
		string = in.nextLine();
		System.out.println(" Вывод:");
		System.out.print(string);
		System.out.println();
	}
}
