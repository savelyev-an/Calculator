package com.innopolis.study.java2016.savelyev.lessons.lesson12;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by User on 19.10.2016.
 */
public class SampleFileReader {
	public static void main(String[] args) throws IOException {

	URL U1 = new URL ("file:./source.txt");
	try(Scanner scanner = new Scanner(U1.openStream())) {
		while (scanner.hasNext()) {
			System.out.println( scanner. nextLine());
		}
	};

}
}
