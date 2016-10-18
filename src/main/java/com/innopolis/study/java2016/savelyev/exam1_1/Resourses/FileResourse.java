package com.innopolis.study.java2016.savelyev.exam1_1.Resourses;

/**
 * Created by User on 09.10.2016.
 */
public class FileResourse {
	FileResourse (){
		System.out.println("Запущен конструктор FileResourse");
	}

	public boolean hasHext (){
		System.out.println("hasNext");
		return true;
	}

	public String  next () {
		System.out.println("Next");
		return "Мама";
	}
}
