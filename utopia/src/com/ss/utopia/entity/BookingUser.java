package com.ss.utopia.entity;

import java.util.Objects;

public class BookingUser {

	private int booking_id;
	private int user_id;
	private Booking booking;
	private User user;
	
	public BookingUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingUser(int booking_id, int user_id, Booking booking, User user) {
		super();
		this.booking_id = booking_id;
		this.user_id = user_id;
		this.booking = booking;
		this.user = user;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking_id, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingUser other = (BookingUser) obj;
		return booking_id == other.booking_id && user_id == other.user_id;
	}

	@Override
	public String toString() {
		return "BookingUser [booking_id=" + booking_id + ", user_id=" + user_id + ", booking=" + booking + ", user="
				+ user + "]";
	}
	
}
