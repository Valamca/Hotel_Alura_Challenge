package com.alura.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.Model.Reservation;
import com.alura.hotel.Model.User;

public class userDAO {

	private Connection con;
	
	public userDAO(Connection con) {
		this.con = con;
	}
	
	public int saveUser(User user) { //Guardar usuario en la base de datos
		try {
			this.con.setAutoCommit(false);
			final PreparedStatement statement = con.prepareStatement("INSERT INTO user "
					+ "(user_name, password)" + " VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				executeRecord(statement, user);
				con.commit();
				con.close();
			}

		} catch (SQLException E) {
			throw new RuntimeException(E);
		}
		return user.getId();
	}
	
	private void executeRecord(PreparedStatement statement, User user) throws SQLException { // Obtener
		
		statement.setString(1, user.getUserName()); // Columnas deseadas y se envian
		statement.setString(2, user.getPassword());
		statement.execute();

		final ResultSet resultset = statement.getGeneratedKeys();
		try (resultset) {
			while (resultset.next()) {
				user.setId(resultset.getInt(1));
				System.out.println(String.format("Se genero el usuario con el codigo %d", user.getId()));
			}
		}
	}
	
	public User getUserByUserName(String UserName) {
	    User User1 = null;
	   
	    try { //el con se cierra en el método que llame el controller o el metodo que llame a este método desde otra clase.
	        final PreparedStatement statement = con.prepareStatement(
	                "SELECT "
	        			 + "id_user, "
	                	 + "user_name, "
		                 + "password "
	               + "FROM user "
	               + "WHERE user_name = ?");
	        
	        try (statement) {
	            statement.setString(1, UserName);
	            statement.execute();
	            
	            ResultSet resultSet = statement.getResultSet();
	            
	            while (resultSet.next()) {
	                User fila = new User(
	                        resultSet.getString("user_name"),
	                        resultSet.getString("password")
	                );
	                fila.setId(resultSet.getInt("id_user"));
	                
	                User1 = fila;
	            }
	            
	            return User1;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Error al recuperar al usuario con id: " + e);
	    }
	}
	
}
