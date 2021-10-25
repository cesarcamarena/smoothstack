package com.ss.utopia.entity;

import java.sql.Date;
import java.util.Objects;

public class Passenger {

	private int id;
	private int booking_id;
	private String given_name;
	private String family_name;
	private Date dob;
	private String gender;
	private String address;
	private Booking booking;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(int id, int booking_id, String given_name, String family_name, Date dob, String gender,
			String address, Booking booking) {
		super();
		this.id = id;
		this.booking_id = booking_id;
		this.given_name = given_name;
		this.family_name = family_name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.booking = booking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", booking_id=" + booking_id + ", given_name=" + given_name + ", family_name="
				+ family_name + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", booking=" + booking
				+ "]";
	}
	
}
