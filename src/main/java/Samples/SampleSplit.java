package Samples;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by User on 12.10.2016.
 */
public class SampleSplit {
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile(":|;| |.");
//		String[] animals = pattern.split("cat:dog;bi rd:cow");
//		Arrays.asList(animals).forEach(animal -> System.out.println(animal + " "));
//
//		String m= "ФФф орлор длшйц";
////		String n[] = m.split(".| |,|;");
//		String n[] = m.split("[А-Яа-я]*");
//
//
//		for (int i=0; i<n.length; i++) System.out.println(i+" "+n[i]);
//// создали какую-то строку с разными разделителями

//		String pattern = "\\s+|,\\s*";
//		String pattern = "\\s*";
//		String inputString = "Просто, строка	в,	java";
//		inputString =    inputString.replaceAll(".|,", " ");
//		System.out.println( inputString);
//		String[] splitResult = inputString.split(" ");
//		System.out.println(Arrays.toString(splitResult));


//		http://metanit.com/java/tutorial/7.4.php

		String input = "Hello Java! Hello JavaScript! JavaSE 8.";
		Pattern pattern = Pattern.compile("[ ,.!?]");
		String[] words = pattern.split(input);
		for(String word:words)
			System.out.println(word);

		System.out.println("Второй способ");
		pattern = Pattern.compile("\\s*(\\s|:|;|&|,|!|\\.)\\s*");
		words = pattern.split(input);
		for(String word:words)
			System.out.println(word);

		System.out.println("Третий способ");
		input = "Hello Java! Hello JavaScript! JavaSE 8. Шел третий час ебли с Regex";

		pattern = Pattern.compile("\\s*([^A-Za-zА-Яа-я])\\s*");
		words = pattern.split(input);
		for(String word:words)
			System.out.println(word);


		System.out.println("Четвертый способ");
		input = "Hello Java! Hello JavaScript! JavaSE 8. Шел третий час ебли с Regex";

		pattern = Pattern.compile("[^A-Za-zА-Яа-я]+");
		String foreignsLetters = "[A-Za-z]+";
		String RussianLetters ="[А-Яа-я]+";
		words = pattern.split(input);
		for(String word:words) {
			System.out.print(word);
			if (!word.matches (RussianLetters)) System.out.println(" - есть иностранные буквы");
				else System.out.println(" чисто русское слово !");

		}
		System.out.println("конец ебли");

		System.out.println("Проверка на кошках");
		input = "Собака КоньQ КозаQ A B C D E F G H I J K L M N O P Q";

		words = pattern.split(input);
		for(String word:words) {
			System.out.print(word);
			if (!word.matches (RussianLetters)) System.out.println(" - есть иностранные буквы");
			else System.out.println(" чисто русское слово !");

		}
		System.out.println("конец ебли");
	}
}
