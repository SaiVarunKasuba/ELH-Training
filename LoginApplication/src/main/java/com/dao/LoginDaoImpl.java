package com.dao;

import com.exception.MyException;
import com.model.User;

public class LoginDaoImpl implements LoginDao {

	
	public User readByUserIdAndpassword(User user) throws MyException {
		if (user.getUserId() == 543210 && user.getPassword().equals("Saivarun")) {
			user.setUserName("Sai");
		}
		else if (user.getUserId() == 543211 && user.getPassword().equals("SaiVarun123")) {
			user.setUserName("Varun");
		}
		else
		{
			throw new MyException("No Such User");
		}

		return user;
	}

	

}
