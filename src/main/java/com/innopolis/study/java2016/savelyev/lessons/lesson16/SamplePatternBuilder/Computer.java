package com.innopolis.study.java2016.savelyev.lessons.lesson16.SamplePatternBuilder;


/**
 * Created by User on 25.10.2016.
 */
public class Computer {
	private static final String DELIMITOR =" # ";
	private final String motherBoard;
	private final  String processor;
	private final String hdd;
	private final String os;

	private	Computer (Builder builder) {
		this.motherBoard = builder.motherBoard;
		this.processor = builder.processor;
		this.hdd = builder.hdd;
		this.os = builder.os;

	}
	public String getMotherBoard() {
		return motherBoard;
	}

		public String getProcessor() {
		return processor;
	}


	public String getHdd() {
		return hdd;
	}


	public String getOs() {
		return os;
	}


	@Override
	public String toString (){
		return new StringBuilder(this.motherBoard).append (DELIMITOR).append(this.processor).append(DELIMITOR)
				.append(this.hdd).append (DELIMITOR).append(this.os).toString();
	}

	public static class Builder{
		private String motherBoard;
		private String processor;
		private String hdd;
		private String os;

		public  Builder withMotherBoard (String motherBoard) {
			this.motherBoard = motherBoard;
			return this;
		}

		public  Builder withProcessor (String  processor) {
			this. processor =  processor;
			return this;
		}

		public  Builder withHdd (String hdd) {
			this.hdd = hdd;
			return this;
		}

		public  Builder withOs (String  os) {
			this. os =  os;
			return this;
		}

		public Computer build(){
				return new Computer(this);
			}
	}
}
