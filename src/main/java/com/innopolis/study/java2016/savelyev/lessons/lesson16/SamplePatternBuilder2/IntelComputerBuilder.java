package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder2;

/**
 * Created by User on 25.10.2016.
 */
public class IntelComputerBuilder extends AbstractComputerBuilder {
	@Override
	public AbstractComputerBuilder buildMotherBoard() {
		getComputer() . setMotherBoard("IntelMotherBoard");
		return this;
	}

	@Override
	public AbstractComputerBuilder buildProcessor() {
		getComputer().setProcessor("Intel Processor");
		return this;
	}

	@Override
	public AbstractComputerBuilder buildHdd() {
		getComputer().setHdd("Intel Hdd");
		return this;
	}

	@Override
	public AbstractComputerBuilder buildOs() {
		getComputer().setOs("Intel Os");
		return this;
	}
}
