package com.tang.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tangp.config.MainConfigAutowired;
import com.tangp.dao.BookDao;
import com.tangp.service.BookService;

public class IOCTest_Autowired {

	@Test
	public void test01() {
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAutowired.class);
		 printBeans(applicationContext);
		 BookService bookService = applicationContext.getBean(BookService.class);
		 BookDao bookDao = applicationContext.getBean(BookDao.class);

		 
		 System.out.println(bookService);
		 
		 System.out.println(bookDao);

		 bookService.print();
		 
	}
	
	public void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
}
