package com.service;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.MyException;
import com.model.User;

public class LoginServiceImpl implements LoginService {

	
	public User readByUserIdAndpasswordService(User user) throws MyException {
		
		User userDetails = null;
		int userId= String.valueOf(user.getUserId()).length();
		int password= String.valueOf(user.getPassword()).length();

		if(userId>5)
		{
			if(password>5)
			{
				LoginDao loginDao = new LoginDaoImpl();
				userDetails = loginDao.readByUserIdAndpassword(user);
			}
			else
			{
				throw new MyException("Please Enter 5 password characters");
			}
		}
		else
		{
			throw new MyException("Please Enter 5 user characters");
		}
		return userDetails;
		
	}

}
