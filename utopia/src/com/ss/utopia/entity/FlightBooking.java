package com.ss.utopia.entity;

import java.util.Objects;

public class FlightBooking {

	private int flight_id;
	private int booking_id;
	private Flight flight;
	private Booking booking;
	
	public FlightBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightBooking(int flight_id, int booking_id, Flight flight, Booking booking) {
		super();
		this.flight_id = flight_id;
		this.booking_id = booking_id;
		this.flight = flight;
		this.booking = booking;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking_id, flight_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightBooking other = (FlightBooking) obj;
		return booking_id == other.booking_id && flight_id == other.flight_id;
	}

	@Override
	public String toString() {
		return "FlightBooking [flight_id=" + flight_id + ", booking_id=" + booking_id + ", flight=" + flight
				+ ", booking=" + booking + "]";
	}
	
}
