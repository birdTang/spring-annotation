package com.tangp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.bean.Person;
import com.tangp.config.MainConfig;

public class MainTest {

	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
//		Person person = applicationContext.getBean(Person.class);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfig.class);
		Person person = applicationContext.getBean(Person.class);

		String[] beanName = applicationContext.getBeanNamesForType(Person.class);
		for (String string : beanName) {
			System.out.println(string);
		}
		System.out.println(person);

	}
}
