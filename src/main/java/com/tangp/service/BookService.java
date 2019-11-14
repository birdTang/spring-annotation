package com.tangp.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tangp.dao.BookDao;

@Service
public class BookService {

	/**
	 * 	1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
	 *	2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查
	 */
	@Qualifier("bookDao")
	@Autowired(required = false)
//	@Resource(name = "bookDao2")
	@Inject
	private BookDao bookDao;
	
	public void print() {
		System.out.println("BookService的"+bookDao);
	}
}
