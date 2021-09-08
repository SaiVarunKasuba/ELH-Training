package com.service;

import com.exception.MyException;
import com.model.User;

public interface LoginService {
	public abstract User createUser(User user)throws MyException;
	public abstract User readUser(User user);
	public abstract User updateUser(User user);
	public abstract User deleteUser(User user);
}
