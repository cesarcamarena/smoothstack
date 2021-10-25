package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class Booking {

	private int id;
	private short is_active;	//0 or 1 in database, like a boolean
	private String confirmation_code;
	private List<FlightBooking> flight_bookings;
	private BookingPayment booking_payment;
	private BookingAgent booking_agent;
	private BookingUser booking_user;
	private BookingGuest booking_guest;
	private List<Passenger> passengers;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int id, short is_active, String confirmation_code, List<FlightBooking> flight_bookings,
			BookingPayment booking_payment, BookingAgent booking_agent, BookingUser booking_user,
			BookingGuest booking_guest, List<Passenger> passengers) {
		super();
		this.id = id;
		this.is_active = is_active;
		this.confirmation_code = confirmation_code;
		this.flight_bookings = flight_bookings;
		this.booking_payment = booking_payment;
		this.booking_agent = booking_agent;
		this.booking_user = booking_user;
		this.booking_guest = booking_guest;
		this.passengers = passengers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(short is_active) {
		this.is_active = is_active;
	}

	public String getConfirmation_code() {
		return confirmation_code;
	}

	public void setConfirmation_code(String confirmation_code) {
		this.confirmation_code = confirmation_code;
	}

	public List<FlightBooking> getFlight_bookings() {
		return flight_bookings;
	}

	public void setFlight_bookings(List<FlightBooking> flight_bookings) {
		this.flight_bookings = flight_bookings;
	}

	public BookingPayment getBooking_payment() {
		return booking_payment;
	}

	public void setBooking_payment(BookingPayment booking_payment) {
		this.booking_payment = booking_payment;
	}

	public BookingAgent getBooking_agent() {
		return booking_agent;
	}

	public void setBooking_agent(BookingAgent booking_agent) {
		this.booking_agent = booking_agent;
	}

	public BookingUser getBooking_user() {
		return booking_user;
	}

	public void setBooking_user(BookingUser booking_user) {
		this.booking_user = booking_user;
	}

	public BookingGuest getBooking_guest() {
		return booking_guest;
	}

	public void setBooking_guest(BookingGuest booking_guest) {
		this.booking_guest = booking_guest;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
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
		Booking other = (Booking) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", is_active=" + is_active + ", confirmation_code=" + confirmation_code
				+ ", flight_bookings=" + flight_bookings + ", booking_payment=" + booking_payment + ", booking_agent="
				+ booking_agent + ", booking_user=" + booking_user + ", booking_guest=" + booking_guest
				+ ", passengers=" + passengers + "]";
	}
	
}
