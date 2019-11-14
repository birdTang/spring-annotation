package com.tang.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.tangp.config.MainConfigPropertyValue;

public class IOCTest_PropertyValue {

	@Test
	public void test01() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigPropertyValue.class);
		 printBeans(applicationContext);
		 Object bean = applicationContext.getBean("person");
		 System.out.println(bean);
		 
		 ConfigurableEnvironment environment = applicationContext.getEnvironment();
		 String property = environment.getProperty("person.nickName");
		 System.out.println(property);
		 applicationContext.close();
		 
	}
	
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
