package com.tang.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.ext.ExtConfig;

public class IOCTest_EXT {

	@Test
	public void testExt() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
		 printBeans(applicationContext);
		 
	}
	
	@Test
	public void testEventListener() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
		 
		 applicationContext.publishEvent(new ApplicationEvent(new String("我自己发布了事件")) {
		});
		 
		 printBeans(applicationContext);
		 applicationContext.close();
	}
	
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
