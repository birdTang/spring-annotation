package com.tangp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangp.dao.BookDao;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	public void print() {
		System.out.println("BookService的"+bookDao);
	}
}
