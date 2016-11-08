package com.innopolis.study.java2016.savelyev.lessons.lesson12;

import jdk.nashorn.api.scripting.URLReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by User on 19.10.2016.
 */
public class SampleURLConnection {

	public static void main(String[] args) throws IOException {
		URL U1 = new URL ("http://www.rbc.ru");
		try(Scanner scanner = new Scanner(U1.openStream())) {
			while (scanner.hasNext()) {
				System.out.println( scanner. nextLine());
			}
		};

	}
}
