package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder2;



/**
 * Created by User on 25.10.2016.
 */
public class Computer {
	private final String DELIMITOR =" # ";
	private String motherBoard;
	private String processor;
	private String hdd;
	private String os;

	public String getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	@Override
	public String toString (){
		return (String)new StringBuilder(this.motherBoard).append (DELIMITOR).append(DELIMITOR).append(this.processor).toString();
	}
}
