package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder2;

/**
 * Created by User on 25.10.2016.
 */
public class StartPointBuilder {
	public static void main(String[] args) {
		ComputerBuildManager computerBuildManager = new ComputerBuildManager();
		computerBuildManager.setComputerBuilder(new IntelComputerBuilder());
		System.out.println(computerBuildManager.toString());
	}
}
