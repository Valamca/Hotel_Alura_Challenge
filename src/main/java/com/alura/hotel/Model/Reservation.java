package com.alura.hotel.Model;

import java.sql.Date;

public class Reservation {

	private Long id;
	private Date checkInDate;
	private Date checkOutDate;
	private double value;
	private String paymentMethod;
	
	public Reservation() {}
	
	public Reservation(Date checkInDate, Date checkOutDate, double value, String paymentMethod) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.value = value;
		this.paymentMethod = paymentMethod;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", value="
				+ value + ", paymentMethod=" + paymentMethod + "]";
	}
	
}
