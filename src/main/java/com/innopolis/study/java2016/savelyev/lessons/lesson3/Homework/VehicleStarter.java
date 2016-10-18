package com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework;
// пример из лекции 13 интуит

interface Vehicle {
	void go();
}
class Automobile implements Vehicle {
	public void go() {
		System.out.println("Automobile go!");
	}
}
class Truck implements Vehicle {
	public Truck(int i) {
		// Будет ошибка - т.к. конструктор без пареметров отсутсвует!!!
		super();
	}
	public void go() {
		System.out.println("Truck go!");
	}
}
public class VehicleStarter {
	public static void main(String[] args) {
		Vehicle vehicle;
		String[] vehicleNames = {"com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework.Automobile",
				"com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework.Truck",
				"com.innopolis.study.java2016.savelyev.test.lessons.lesson3.Homework.Tank"};
		for(int i=0; i<vehicleNames.length; i++) {
			try {
				String name = vehicleNames[i];
				System.out.println("look for class for: " + name);
				Class aClass = Class.forName(name);
				System.out.println("creating vehicle...");
				vehicle = (Vehicle)aClass.newInstance();
				System.out.println("create vehicle: " + vehicle.getClass());
				vehicle.go();
			} catch(ClassNotFoundException e) {
				System.out.println("Exception: " + e);
			} catch(InstantiationException e) {
				System.out.println("Exception: " + e);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
