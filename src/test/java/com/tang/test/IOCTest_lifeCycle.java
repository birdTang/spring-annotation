package com.tang.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.config.MainConfigOfLifeCycle;

public class IOCTest_lifeCycle {

	@Test
	public void test01() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		 printBeans(applicationContext);
		 applicationContext.getBean("car");
		 applicationContext.close();
		 
	}
	
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
