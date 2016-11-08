package com.innopolis.study.java2016.savelyev.lessons.lesson16.S2;

/**
 * Created by User on 25.10.2016.
 */
public class Bank {

}

abstract class AbstructBankFactory{
//	public get
}

class sum {

}

abstract class Product {
	private String Desc;

	public Product(String desc) {
		Desc = desc;
	}

	public String getDesc() {
		return Desc;
	}
}

class loan extends Product {
	public loan(String desc) {
		super(desc);
	}

class insurance extends Product{
	public insurance(String desc) {
		super(desc);
	}
}
class vklad extends Product{
	public vklad(String desc) {
		super(desc);
	}
}

};