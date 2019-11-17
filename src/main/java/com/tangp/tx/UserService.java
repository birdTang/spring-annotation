package com.tangp.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public void insert() {
		userDao.insert();
	}
}
