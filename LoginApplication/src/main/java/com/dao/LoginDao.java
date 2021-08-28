package com.dao;

import com.exception.MyException;
import com.model.User;

public interface LoginDao {
	public abstract User readByUserIdAndpassword(User user) throws MyException;
}
