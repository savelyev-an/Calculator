package com.innopolis.study.java2016.savelyev.exam_1_reliz_unsupported;

/**
 * Created by User on 12.10.2016.
 */
class BoxException {
	private Exception globalException;

	public BoxException() {this.globalException = null;}

	public Exception getValue() { return globalException;}

	public void setValue(Exception globalException ) {this.globalException = globalException;}
}
