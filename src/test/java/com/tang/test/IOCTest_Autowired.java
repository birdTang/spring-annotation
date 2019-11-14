package com.tang.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.bean.autowired.Boss;
import com.tangp.bean.lifecycle.Car;
import com.tangp.bean.register.Color;
import com.tangp.config.MainConfigAutowired;
import com.tangp.config.MainConfigProfile;
import com.tangp.service.BookService;

public class IOCTest_Autowired {

	@Test
	public void test01() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAutowired.class);
		 printBeans(applicationContext);
		 BookService bookService = applicationContext.getBean(BookService.class);
//		 BookDao bookDao = applicationContext.getBean(BookDao.class);

		 System.out.println("applicationContext"+applicationContext);
//		 System.out.println(bookService);
		 
//		 System.out.println(bookDao);

		 bookService.print();
		 
		 Car bean = applicationContext.getBean(Car.class);
		 Boss bean2 = applicationContext.getBean(Boss.class);
		Color color = applicationContext.getBean(Color.class);
		 System.out.println("Boss car " + (bean==bean2.getCar()));
		 System.out.println("color car " + (color.getCar()==bean));
		 
	}
	/**
	 * 1.使用命令行参数：jvm启动参数中设置 -Dspring.profiles.active=test
	 * 2.使用代码方式，激活某种环境，如下
	 */
	@Test
	public void testProfile() {
		//创建一个applicationContext
		//设置激活环境
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("test","dev");
		//3.注册配置类
		applicationContext.register(MainConfigProfile.class);
		 applicationContext.refresh();
		 
		 printBeans(applicationContext);
	}
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
