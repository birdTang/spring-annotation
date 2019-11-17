package com.tang.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.tangp.bean.Person;
import com.tangp.config.MainConfig;
import com.tangp.config.MainConfigAddBean;

public class IOCTest {

	@Test
	public void testCompentScan() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfig.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.err.println(string);
		}
	}

	@Test
	public void testCompentScope() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigAddBean.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.err.println(string);
		}
		System.out.println("ioc容器创建完成");
		Person person1 = applicationContext.getBean(Person.class);
//		Person person2 = applicationContext.getBean(Person.class);
//		System.out.println(person1 == person2);

	}
	
	@Test
	public void testCompentConditional() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigAddBean.class);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.out.println(environment.getProperty("os.name"));
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.err.println(string);
		}
		Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
		System.out.println(beansOfType);

	}
	
	@Test
	public void TextImport() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAddBean.class);
		printBeans(applicationContext);
//		//工厂bean获取到的是调用getObject创建的对象
//		Object bean = applicationContext.getBean("colorFactoryBean");
//		Object bean2 = applicationContext.getBean("colorFactoryBean");
//
//		System.out.println("colorFactoryBean的类型"+bean.getClass());
//		System.out.println(bean==bean2);
//		
//		Object bean3 = applicationContext.getBean("&colorFactoryBean");
//		System.out.println(bean3.getClass());
		
	}
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
