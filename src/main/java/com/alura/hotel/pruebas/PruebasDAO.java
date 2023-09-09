package com.alura.hotel.pruebas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.alura.hotel.Controller.ReservationController;
import com.alura.hotel.CreateConnection.ConnectionFactory;
import com.alura.hotel.Dao.reservationsDAO;
import com.alura.hotel.Model.Reservation;

public class PruebasDAO {

	public static void main(String[] args) throws SQLException {
		
        Date entrada = Date.valueOf("2023-09-25");
        Date salida = Date.valueOf("2023-10-09");
		double value = 1500;
		String paymentMethod = "Tarjeta de débito";
		Long id = 9l;
		
		ConnectionFactory CF = new ConnectionFactory();
		Connection con = CF.recoverConnection() ;
		
		reservationsDAO rDao = new reservationsDAO(con);
		ReservationController reControl = new ReservationController();
		Reservation reservation = new Reservation(entrada, salida, value, paymentMethod);

		//reservation.setId(4l);
		
		//rDao.saveReservation(reservation);
		//System.out.println(rDao.listReservations());
		//System.out.println(rDao.getReservationById(4l));
		//System.out.println(rDao.update(reservation));
		//System.out.println(rDao.delete(6l));
		
		//System.out.println(reControl.saveReservation(entrada,salida,value,paymentMethod));//Funciona Correctamente
		//reControl.deleteReservation(8); //Funciona Correctamente
		//System.out.println(reControl.reservationList());//Funciona Correctamente
		//System.out.println(reControl.reservationDyID(9)); //Funciona Correctamente
		//System.out.println(reControl.updateReservation(reservation,id)); //Funciona Correctamente
		


		con.close();
	}
}
