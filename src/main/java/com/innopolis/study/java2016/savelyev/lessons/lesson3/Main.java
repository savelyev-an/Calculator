package com.innopolis.study.java2016.savelyev.test.lessons.lesson3;
//**Example of order of Autocloseable

import com.innopolis.study.java2016.savelyev.test.lessons.lesson3.entity.Car;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main (String[] args ) {
	/*
			try (DBResourse dbResourse =  new DBResourse();
			NetResourse netResourse=new NetResourse())
		{System.out.println("Success");
		throw new Exception(); }
		catch (Exception e) {
			e.printStackTrace();
		}
	*/

	try (FileOutputStream fileOutputStream= new FileOutputStream("./Cars");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream (fileOutputStream)) {
			Car car = new Car ("Lada Vesta", "A808CO21RUS");
			objectOutputStream.writeObject(car);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}


