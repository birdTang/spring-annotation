package com.tang.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.config.MainConfigTx;
import com.tangp.tx.UserService;

public class IOCTest_TX {

	@Test
	public void test01() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigTx.class);
		 printBeans(applicationContext);
		 
		 UserService userService = applicationContext.getBean(UserService.class);
		 userService.insert();
	}
	
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
