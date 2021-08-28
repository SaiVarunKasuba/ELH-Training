package com.service;

import com.exception.MyException;
import com.model.User;

public interface LoginService {
	public abstract User readByUserIdAndpasswordService(User user) throws MyException;
}
