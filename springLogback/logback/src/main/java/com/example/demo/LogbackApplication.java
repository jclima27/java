package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackApplication {

	private static Logger Logger = LoggerFactory.getLogger(LogbackApplication.class);
	
	public static void main(String[] args) {
		Logger.trace("doStuff needed more information - {}");
	    Logger.debug("doStuff needed to debug - {}");
	    Logger.info("doStuff took input - {}");
	    Logger.warn("doStuff needed to warn - {}");
	    Logger.error("doStuff encountered an error with value - {}");
		SpringApplication.run(LogbackApplication.class, args);
		
	}

}
