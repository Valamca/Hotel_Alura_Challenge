package com.alura.hotel.Controller;

import java.util.List;

import com.alura.hotel.CreateConnection.ConnectionFactory;
import com.alura.hotel.Dao.userDAO;
import com.alura.hotel.Model.User;

public class UserController {

	private userDAO userDao;
	
	public UserController() {
		this.userDao = new userDAO(new ConnectionFactory().recoverConnection());
	}
	
	public int saveUser(String username, String password) {
		User user = new User(username, password);
		return userDao.saveUser(user);
	}
	
	public User getUserByUserName(String userName){
		return userDao.getUserByUserName(userName);
	}
}
