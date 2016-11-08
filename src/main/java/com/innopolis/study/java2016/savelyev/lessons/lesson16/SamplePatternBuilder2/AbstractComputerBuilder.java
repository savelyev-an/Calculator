package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder2;

/**
 * Created by User on 25.10.2016.
 */
public abstract class AbstractComputerBuilder {


	private Computer computer;

	public void createNewCompute (){
		this.computer= new Computer();
	}

	public Computer getComputer() {
		return computer;
	}

	public abstract AbstractComputerBuilder buildMotherBoard();
	public abstract AbstractComputerBuilder buildProcessor();
	public abstract AbstractComputerBuilder buildHdd();
	public abstract AbstractComputerBuilder buildOs();

}
