package com.service;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.exception.MyException;
import com.model.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public User createUser(User user) throws MyException {
		User details = null;
		int userId= String.valueOf(user.getUserId()).length();
		int password= String.valueOf(user.getPassword()).length();
		if(userId>=5)
		{
			if(password>5)
			{
				LoginDao loginDao = new LoginDaoImpl();
				details = loginDao.createUser(user);
			}
			else
			{
				throw new MyException("Please Enter 5 characters of password");
			}
		}
		else
		{
			throw new MyException("Please Enter 5 characters of userId");
		}
		
		return details;
	}

	@Override
	public User readUser(User user) {
		User details=null;
	
		LoginDao loginDao = new LoginDaoImpl();
		details = loginDao.readUser(user);
		
		return details;
	}

	@Override
	public User updateUser(User user) {
		//System.out.println("User Service"+user.getUserName());
		User details=null;
		
		LoginDao loginDao = new LoginDaoImpl();
		details = loginDao.updateUser(user);
		
		return details;
	}

	@Override
	public User deleteUser(User user) {
		User details=null;
		
		LoginDao loginDao = new LoginDaoImpl();
		details = loginDao.deleteUser(user);
		
		return details;
	}

}
