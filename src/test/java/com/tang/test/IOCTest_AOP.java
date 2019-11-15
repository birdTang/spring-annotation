package com.tang.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.aop.MathCalculator;
import com.tangp.config.MainConfigAOP;

public class IOCTest_AOP {

	@Test
	public void test01() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAOP.class);
		 printBeans(applicationContext);
		 
		 MathCalculator math = applicationContext.getBean(MathCalculator.class);
		 math.div(1, 0);
		 applicationContext.close();
		 
	}
	
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
