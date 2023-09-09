package com.alura.hotel.Controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.CreateConnection.ConnectionFactory;
import com.alura.hotel.Dao.guestDAO;
import com.alura.hotel.Model.Guest;

public class GuestController {
	
	private guestDAO guestDao;
	
	public GuestController() {
		this.guestDao = new  guestDAO(new ConnectionFactory().recoverConnection());
	}
	
	public Long saveGuesData(String name, String lastName, Date birthDate, String nationality, 
														String phoneNumber,Long reservationId) { 
		Guest guestData = new Guest(name, lastName, birthDate, nationality, phoneNumber, reservationId);
		return guestDao.saveGuest(guestData); //Guardar información de Cliente en Base de dATOS
	}
	
	public int updateGuestDate(Long id, String name, String lastName, Date birthDate, 
												String nationality, String phoneNumber,Long reservationId) {
		
		Guest guestData = new Guest(id, name, lastName, birthDate, nationality, phoneNumber, reservationId);
		return guestDao.updateGuest(guestData); //Actualizar información de un cliente
	}
	
	public int deleteGuestData(int idGuest) { //Eliminar información de un cliente
		return guestDao.deleteGuest(idGuest);
	}
	
	public List<Guest> getGuestList(){ //Obtener información de los clientes en la base de datos
		return guestDao.getGuests();
	}
	
	public List<Guest> getGuestDataByLasName(String last_name){  //Obtener información de un cliente por su Apellido
		return guestDao.getByLastName(last_name);
	}
	
	public List<Guest> getGuestDataByReservationId(int id_reservation){ //Obtener información de un cliente por su id de reservación
		return guestDao.getByReservation(id_reservation);
	}
}
