package Samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 15.11.2016.
 */
public class SampleLog4j {
	private static  Logger logger = LoggerFactory.getLogger("application");
//	private static  Logger logger = LoggerFactory.getLogger(SampleLog4j.class);
	public static void main(String[] args) {
		logger.info(SampleLog4j.class.toString()+"Фага3");
		logger.info("Фага1");
	}
}

//      Настройки log4j.properties для создания лога по "имени"
//		log4j.logger.application = INF0, application
//
//		log4j.appender.application=org.apache.log4j.RollingFileAppender
//		log4j.appender.application.file=application.log
//		log4j.appender.application.file.MaxBackupIndex=10
//		log4j.appender.application.file.MaxFileSize=100MB
//		log4j.appender.application.layout=org.apache.log4j.EnhancedPatternLayout
//		log4j.appender.application.layout.conversionPattern=%d{ISO8601} [%-5p][%-16.16t][%20c{-2}] - %m%n

