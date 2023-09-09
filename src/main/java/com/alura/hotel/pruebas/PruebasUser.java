package com.alura.hotel.pruebas;

import java.sql.Connection;

import com.alura.hotel.CreateConnection.ConnectionFactory;
import com.alura.hotel.Dao.userDAO;
import com.alura.hotel.Model.User;

public class PruebasUser {

	public static void main(String[] args) {
		
		String name="kkk";
		String password="huevos1";
		
		ConnectionFactory Factory = new ConnectionFactory();
		Connection con = Factory.recoverConnection();
		
		userDAO userDao = new userDAO(con);
		
		User user = new User(name, password);
		
		System.out.println(userDao.saveUser(user)); //Funciona Perfectamente
		
	}
}
