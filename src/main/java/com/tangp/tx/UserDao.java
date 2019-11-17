package com.tangp.tx;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public void insert() {
		String sql = "INSERT INTO `user`(username,age) VALUES(?,?)";
		String username = UUID.randomUUID().toString().substring(0, 5);
		jdbcTemplate.update(sql, username,19);
	}
}
