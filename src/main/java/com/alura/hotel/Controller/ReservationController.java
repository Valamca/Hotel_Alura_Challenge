package com.alura.hotel.Controller;


import java.sql.Date;
import java.util.List;

import com.alura.hotel.CreateConnection.ConnectionFactory;
import com.alura.hotel.Dao.reservationsDAO;
import com.alura.hotel.Model.Reservation;

public class ReservationController {

	private reservationsDAO reservationDAO;

	public ReservationController() {
		this.reservationDAO = new reservationsDAO(new ConnectionFactory().recoverConnection());
	}
	
	public Long saveReservation(Date dateIn, Date dateOute, double value, String payMethod) {//Constructor de 4 parametos  DATE DATE DOUBLE STRING
		Reservation reservationSave = new Reservation(dateIn, dateOute, value, payMethod);
		return reservationDAO.saveReservation(reservationSave);//sysout Long
	}
	
	public int updateReservation(Reservation updreserv, Long id) { //actualizar datos de reservación
		updreserv.setId(id);
		return reservationDAO.update(updreserv);//sysout para comprobar
	}
	
	public int deleteReservation(int id) {//eliminar datos de reservación
		int rule = reservationDAO.delete(id);
		if(rule == -1){
			return 0;
		}
		return rule;//sysout int para comprobar
	}
	
	public List<Reservation> reservationList() { //obtener la lista de reservaciones disponibles
		return this.reservationDAO.listReservations();//sysout para comprobar
	}
	
	public List<Reservation> reservationDyID(int id){ //obtener reservación por su ID
		return this.reservationDAO.getReservationById(id);//sysout para comprobar
	}
	
}
