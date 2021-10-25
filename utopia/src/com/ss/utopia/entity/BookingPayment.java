package com.ss.utopia.entity;

import java.util.Objects;

public class BookingPayment {

	private int booking_id;
	private String stripe_id;
	private short refunded;
	private Booking booking;
	
	public BookingPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingPayment(int booking_id, String stripe_id, short refunded, Booking booking) {
		super();
		this.booking_id = booking_id;
		this.stripe_id = stripe_id;
		this.refunded = refunded;
		this.booking = booking;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getStripe_id() {
		return stripe_id;
	}

	public void setStripe_id(String stripe_id) {
		this.stripe_id = stripe_id;
	}

	public short getRefunded() {
		return refunded;
	}

	public void setRefunded(short refunded) {
		this.refunded = refunded;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking_id, stripe_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingPayment other = (BookingPayment) obj;
		return booking_id == other.booking_id && Objects.equals(stripe_id, other.stripe_id);
	}

	@Override
	public String toString() {
		return "BookingPayment [booking_id=" + booking_id + ", stripe_id=" + stripe_id + ", refunded=" + refunded
				+ ", booking=" + booking + "]";
	}
	
}
