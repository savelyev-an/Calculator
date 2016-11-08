package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder2;

/**
 * Created by User on 25.10.2016.
 */
public class ComputerBuildManager {
	private AbstractComputerBuilder computerBuilder;

	public void setComputerBuilder(AbstractComputerBuilder computerBuilder) {
		this.computerBuilder = computerBuilder;
	}

	public Computer build (){
		Computer result = null;
		this.computerBuilder .createNewCompute();
		this.computerBuilder .buildMotherBoard().buildProcessor().buildHdd().buildOs();
//		this.computerBuilder .build();

		return result;
	}
}
