package com.main;

import java.util.Scanner;

import com.exception.MyException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("Project Started");
		System.out.println("Enter 1 to create : ");
		System.out.println("Enter 2 to read : ");
		System.out.println("Enter 3 to update : ");
		System.out.println("Enter 4 to delete : ");
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		LoginService loginService = new LoginServiceImpl();
		User details = null;
		switch (value) {
		case 1:
			System.out.println("Enter User Id : ");
			int userId = scanner.nextInt();
			user.setUserId(userId);
			System.out.println("Enter User Name : ");
			String userName = scanner.next();
			user.setUserName(userName);
			System.out.println("Enter Pasword : ");
			String userPassword = scanner.next();
			user.setPassword(userPassword);

			try {
				details = loginService.createUser(user);
			} catch (MyException e) {

				System.err.println(e.getMessage());
			}

			if (details != null) {
				System.out.println("Details Added Succesfully : ");
			}
			break;
		case 2:

			System.out.println("Enter User Id To Search : ");
			int searchId = scanner.nextInt();
			user.setUserId(searchId);
			details = loginService.readUser(user);
			if (details != null) {
				System.out.println("Welcome " + details.getUserName());
			}
			break;
		case 3:
			System.out.println("Enter User Id to Update : ");
			int updateId = scanner.nextInt();
			user.setUserId(updateId);
			System.out.println("Enter New Name ");
			String newName = scanner.next();
			user.setUserName(newName);
			details = loginService.updateUser(user);
			if (details != null) {

				System.out.println("Details Updated");
			}
			break;
		case 4:
			System.out.println("Enter Id To Delete : ");
			int idDelete = scanner.nextInt();
			user.setUserId(idDelete);
			details = loginService.deleteUser(user);

			if (details != null) {
				System.out.println("Details Deleted");
			}
			break;
		default:
			System.out.println("Select between 1 to 4");

		}

	}
}
