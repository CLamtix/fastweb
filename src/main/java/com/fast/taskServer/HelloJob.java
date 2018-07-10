package com.fast.taskServer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob{
	private static Logger log = LoggerFactory.getLogger(HelloJob.class);
	
	public void execute() {
		log.info("Hi! i'm helloJob");
		log.debug("我执行完了,please wait 3 seconds!");
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
