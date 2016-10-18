package com.innopolis.study.java2016.savelyev.exam_1_reliz_unsupported;

/**
 * Created by User on 12.10.2016.
 */
public class SampleArgs {
	public static void main(String[] args) {
		System.out.println(args.length);
		String resourse="";
		for (int i=0; i<args.length; i++) {
			resourse = args[i];
			System.out.println(resourse);
		}
	}
}
