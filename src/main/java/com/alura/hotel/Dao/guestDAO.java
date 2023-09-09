package com.alura.hotel.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.Model.Guest;



public class guestDAO {

	private Connection con;

	public guestDAO(Connection con) {
		this.con = con;
	}
	
	public Long saveGuest(Guest guest) {
		
        try{
            con.setAutoCommit(false);
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO guest" 
                    	+"(name, "
                    	+ "last_name, "
                    	+ "birth_date, "
                    	+ "nationality, "
                    	+ "phone_number, "
                    	+ "id_reservation) "
                   + "VALUES " 
                    	+"(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );
            try(statement){
                this.executeRecords(statement,guest);
                con.commit();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return guest.getId();
    }
	
	public void executeRecords(PreparedStatement statement, Guest guest) throws SQLException{
		statement.setString(1, guest.getName()); //Para no hacer repetitivo el metodo de agregar los datos a una instancia Guest
        statement.setString(2, guest.getLastName());
        statement.setDate(3, guest.getBirthDate());
        statement.setString(4,guest.getNationality());
        statement.setString(5,guest.getPhoneNumber());
        statement.setLong(6,guest.getReservationId());

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys(); //Obtener los resultados de haber ingresado los datos a la base de datos

        try(resultSet) {
            while (resultSet.next()) {
                guest.setId(resultSet.getLong(1));
            }
        }
	}
	
	public List<Guest> getGuests() { //Obtienes todos los huespedes de la base de datos del hotel
        List<Guest> guestList = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT " 
                           + "id_guest, " 
                           + "name, " 
                           + "last_name, " 
                           + "birth_date, " 
                           + "nationality, " 
                           + "phone_number, " 
                           + "id_reservation " 
                  + "FROM guest"
            );
            try(statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet();

                while(resultSet.next()){
                    Guest guest = new Guest(

                            resultSet.getString("name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birth_date"),
                            resultSet.getString("nationality"),
                            resultSet.getString("phone_number")
                    );
                    guest.setId(resultSet.getLong("id_guest"));
                    guest.setReservationId(resultSet.getLong("id_reservation"));
                    guestList.add(guest);
                }
                return guestList;
            }


        }catch (SQLException e ) {
            throw new RuntimeException(e);
        }
    }
	
	public List<Guest> getByLastName(String last_name) { //Para llamar a un cliente por su apellido
        List<Guest> guestList = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT "
                            + "id_guest, " 
                            + "name, " 
                            + "last_name, " 
                            + "birth_date, " 
                            + "nationality, " 
                            + "phone_number, " 
                            + "id_reservation " 
                   +"FROM guest WHERE last_name = ?"
            );
            try(statement) {
                statement.setString(1,last_name);
                statement.execute();
                
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                    Guest huesped = new Guest(
                            resultSet.getString("name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birth_date"),
                            resultSet.getString("nationality"),
                            resultSet.getString("phone_number")
                    );
                    huesped.setId(resultSet.getLong("id_guest"));
                    huesped.setReservationId(resultSet.getLong("id_reservation"));
                    guestList.add(huesped);
                }
                return guestList;
            }
        }catch (SQLException e ) {
            throw new RuntimeException(e);
        }
    }
	
	public List<Guest> getByReservation(int id_reservation) { //Obtener el Guest con su numero de reservación
        List<Guest> guestList = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT "
                            + "id_guest, " 
                            + "name, " 
                            + "last_name, " 
                            + "birth_date, " 
                            + "nationality, " 
                            + "phone_number, " 
                            + "id_reservation " 
                   +"FROM guest WHERE id_reservation = ?"
            );
            try(statement) {
                statement.setLong(1,id_reservation);
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                    Guest guest = new Guest(
                            resultSet.getString("name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birth_date"),
                            resultSet.getString("nationality"),
                            resultSet.getString("phone_number")
                    );
                    guest.setId(resultSet.getLong("id_guest"));
                    guest.setReservationId(resultSet.getLong("id_reservation"));
                    guestList.add(guest);
                }
                return guestList;
            }
        }catch (SQLException e ) {
            throw new RuntimeException(e);
        }
    }
	
	public int updateGuest(Guest guest) { //Actualizar datos de un cliente dada su Id de cliente
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE guest SET " 
                    	+"name = ?, " 
                        +"last_name = ?, "
                        +"birth_date = ?, " 
                        +"nationality = ?, " 
                        +"phone_number = ?, " 
                        +"id_reservation = ? " 
                    +" WHERE id_guest = ?"
            );
            try (statement) {
                statement.setString(1,guest.getName());
                statement.setString(2,guest.getLastName());
                statement.setDate(3,guest.getBirthDate());
                statement.setString(4,guest.getNationality());
                statement.setString(5,guest.getPhoneNumber());
                statement.setLong(6,guest.getReservationId());
                statement.setLong(7,guest.getId());

                statement.execute();

                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteGuest(int id_guest) { //Eliminar el cliente dada su ID de cliente
        try {
            final PreparedStatement statement = con.prepareStatement(
            		"DELETE FROM guest "
            	  + "WHERE id_guest = ?");
            try(statement) {
                statement.setLong(1, id_guest);
                statement.execute();
                return statement.getUpdateCount();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
	
}
