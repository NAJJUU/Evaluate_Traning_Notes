package com.earth.najuhwa.dao;

import java.sql.SQLException;

import com.earth.najuhwa.dto.User;

public interface UserDao {

	public User select(String id);
	public int deleteAll() throws SQLException;
	public int insert(User user);
	public int update(User user) throws SQLException;
}
