package com.innopolis.study.java2016.savelyev.exam_1_reliz_unsupported;

/**
 * Created by User on 12.10.2016.
 */
public class OpenResourseException extends ForeignWordException {

	public OpenResourseException(String threadName, String resourseName, String message) {
		super(threadName, resourseName, message);
	}

	public OpenResourseException(String threadName, String resourseName, String message, Exception e) {
		super(threadName, resourseName, message, e);
	}
}
