package com.dao;

import com.model.User;

public interface LoginDao {
	public abstract User createUser(User user);
	public abstract User readUser(User user);
	public abstract User updateUser(User user);
	public abstract User deleteUser(User user);

}
