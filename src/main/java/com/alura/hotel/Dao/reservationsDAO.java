package com.alura.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.alura.hotel.Model.Reservation;

public class reservationsDAO {

	private Connection con;

	public reservationsDAO(Connection con) {
		this.con = con;
	}

	public Long saveReservation(Reservation reservation) {
		try {
			this.con.setAutoCommit(false);
			final PreparedStatement statement = con.prepareStatement("INSERT INTO reservations "
					+ "(check_in_date,check_out_date,value,payment_method)" + " VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				executeRecord(statement, reservation);
				con.commit();
				con.close();
			}

		} catch (SQLException E) {
			throw new RuntimeException(E);
		}
		return reservation.getId();
		
	}

	private void executeRecord(PreparedStatement statement, Reservation reservation) throws SQLException { // Obtener
																											// los
																											// valores
																											// de las
		statement.setDate(1, reservation.getCheckInDate()); // Columnas deseadas y se envian
		statement.setDate(2, reservation.getCheckOutDate());
		statement.setDouble(3, reservation.getValue());
		statement.setString(4, reservation.getPaymentMethod());

		statement.execute();

		final ResultSet resultset = statement.getGeneratedKeys();
		try (resultset) {
			while (resultset.next()) {
				reservation.setId(resultset.getLong(1));
				System.out.println(String.format("Se genero el registro con el codigo %d", reservation.getId()));
			}
		}
	}

	public List<Reservation> listReservations() {
	    List<Reservation> reservationsList = new ArrayList<>();
	    
	    try (PreparedStatement statement = con.prepareStatement(
	            "SELECT id_reservation, "
			         + "check_in_date, "
			         + "check_out_date, "
			         + "value, "
			         + "payment_method "
			            				+ "FROM reservations");
	         ResultSet resultSet = statement.executeQuery()) {

	        while (resultSet.next()) {
	            Reservation fila = new Reservation(
	                    resultSet.getDate("check_in_date"),
	                    resultSet.getDate("check_out_date"),
	                    resultSet.getDouble("value"),
	                    resultSet.getString("payment_method")
	            );
	            fila.setId(resultSet.getLong("id_reservation"));
	            reservationsList.add(fila);
	        }
	        return reservationsList;
	    } catch (SQLException e) {
	        throw new RuntimeException("Error al recuperar las reservaciones", e);
	    }
	}
	
	public List<Reservation> getReservationById(int id) {
	    List<Reservation> reservationList = new ArrayList<>();
	   
	    try { //el con se cierra en el método que llame el controller o el metodo que llame a este método desde otra clase.
	        final PreparedStatement statement = con.prepareStatement(
	                "SELECT id_reservation, "
		                 + "check_in_date, "
		                 + "check_out_date, "
		                 + "value, "
		                 + "payment_method "
	               + "FROM reservations "
	               + "WHERE id_reservation = ?");
	        
	        try (statement) {
	            statement.setLong(1, id);
	            statement.execute();
	            
	            ResultSet resultSet = statement.getResultSet();
	            
	            while (resultSet.next()) {
	                Reservation fila = new Reservation(
	                        resultSet.getDate("check_in_date"),
	                        resultSet.getDate("check_out_date"),
	                        resultSet.getDouble("value"),
	                        resultSet.getString("payment_method")
	                );
	                fila.setId(resultSet.getLong("id_reservation"));
	                
	                reservationList.add(fila);
	            }
	            
	            return reservationList;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Error al recuperar las reservaciones con id: " + e);
	    }
	}
	
	public int update(Reservation reservation) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE reservations SET "
                    	+ "check_in_date = ?," 
                    	+ "check_out_date = ?," 
                    	+ "value = ?," 
                    	+ "payment_method = ? "
                   + "WHERE id_reservation = ?"
            );
            try (statement) {
                statement.setDate(1,reservation.getCheckInDate());
                statement.setDate(2,reservation.getCheckOutDate());
                statement.setDouble(3,reservation.getValue());
                statement.setString(4,reservation.getPaymentMethod());
                statement.setLong(5,reservation.getId());
                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public int delete(int id) {
        try {
            final PreparedStatement statement = con.prepareStatement(
            		"DELETE FROM reservations "
            	  + "WHERE id_reservation = ?");
            try(statement) {
                statement.setLong(1, id);
                statement.execute();
                return statement.getUpdateCount();
            }
        } catch (SQLException e ){
        	JOptionPane.showMessageDialog(new JFrame(), "Elimina primero al huesped relacionado con esta reservación");
        	return -1;
        }
	}
		
}
