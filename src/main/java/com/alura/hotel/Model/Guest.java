	package com.alura.hotel.Model;

import java.sql.Date;

public class Guest {

	private Long id;
	private String name;
	private String lastName;
	private Date birthDate;
	private String nationality;
	private String phoneNumber;
	
	private Long reservationId; //Clave Foranea

	public Guest(Long id, String name, String lastName, Date birthDate, String nationality, String phoneNumber,
			Long reservationId) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.reservationId = reservationId;
	}
	
	

	public Guest(String name, String lastName, Date birthDate, String nationality, String phoneNumber, Long reservationId) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.reservationId = reservationId;
	}

	
	public Guest(String name, String lastName, Date birthDate, String nationality, String phoneNumber) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", nationality=" + nationality + ", phoneNumber=" + phoneNumber + ", reservationId=" + reservationId
				+ "]";
	}
	
	
	
	
	
}
