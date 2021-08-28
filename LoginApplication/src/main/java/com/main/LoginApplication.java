package com.main;

import java.util.Scanner;

import com.exception.MyException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginApplication {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // read from the console
		System.out.println("Enter user id : ");
		int id = input.nextInt(); // user id

		System.out.println("Enter Password");
		String password = input.next(); // password

		LoginService loginService = new LoginServiceImpl();
		User user = new User();
		user.setUserId(id);
		user.setPassword(password);

		User ans=null;
		try {
			ans = loginService.readByUserIdAndpasswordService(user);
		}catch(MyException e)
		{
			System.err.println(e.getMessage());
		}
		
		if (ans != null) {
			System.out.println("Welcome " + ans.getUserName());
		}

	}

}
