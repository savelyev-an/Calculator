package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder;

/**
 * Created by User on 25.10.2016.
 */
public class StartPointBuilder {
	public static void main(String[] args) {
		ComputerBuildManager computerBuildManager = new ComputerBuildManager();
//		computerBuildManager.setComputerBuilder(new IntelComputerBuilder());
		Computer computer = new Computer.Builder().withMotherBoard("AMD MotherBoard").withProcessor(" AMD Processor")
				.withHdd(" AMD HDD").withOs(" Windows !").build();

		System.out.println(computer.toString());
	}
}
