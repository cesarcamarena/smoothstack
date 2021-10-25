package com.ss.utopia.entity;

import java.util.Objects;

public class BookingGuest {

	private int booking_id;
	private String contact_email;
	private String contact_phone;
	private Booking booking;
	
	public BookingGuest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingGuest(int booking_id, String contact_email, String contact_phone, Booking booking) {
		super();
		this.booking_id = booking_id;
		this.contact_email = contact_email;
		this.contact_phone = contact_phone;
		this.booking = booking;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking_id, contact_email, contact_phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingGuest other = (BookingGuest) obj;
		return booking_id == other.booking_id && Objects.equals(contact_email, other.contact_email)
				&& Objects.equals(contact_phone, other.contact_phone);
	}

	@Override
	public String toString() {
		return "BookingGuest [booking_id=" + booking_id + ", contact_email=" + contact_email + ", contact_phone="
				+ contact_phone + ", booking=" + booking + "]";
	}
	
}
