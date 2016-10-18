package com.innopolis.study.java2016.savelyev.lessons.lesson9;

import com.innopolis.study.java2016.savelyev.lessons.lesson9.Streams.StreamWriter;
import com.innopolis.study.java2016.savelyev.lessons.lesson9.jUnit_1.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 13.10.2016.
 */
public class HelloMock {
	public StreamWriter getStreamWriter() {
		return streamWriter;
	}

	public void setStreamWriter(StreamWriter streamWriter) {
		this.streamWriter = streamWriter;
	}

	private StreamWriter streamWriter;

	private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	public static void main(String[] args) {


	}

	public Long handle (String arg){
		Long key = this.streamWriter.write(arg);
		logger.info ("Method handle {}", arg);
		return key;
	}

}
