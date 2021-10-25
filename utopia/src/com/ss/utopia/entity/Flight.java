package com.ss.utopia.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Flight {

	private int id;
	private int route_id;
	private int airplane_id;
	private Timestamp departure_time;
	private int reserved_seats;
	private float seat_price;
	private Route route;
	private Airplane airplane;
	private List<FlightBooking> flight_bookings;
	
	public Flight() {
		super();
	}

	public Flight(int id, int route_id, int airplane_id, Timestamp departure_time, int reserved_seats, float seat_price,
			Route route, Airplane airplane, List<FlightBooking> flight_bookings) {
		super();
		this.id = id;
		this.route_id = route_id;
		this.airplane_id = airplane_id;
		this.departure_time = departure_time;
		this.reserved_seats = reserved_seats;
		this.seat_price = seat_price;
		this.route = route;
		this.airplane = airplane;
		this.flight_bookings = flight_bookings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public int getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}

	public Timestamp getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(Timestamp departure_time) {
		this.departure_time = departure_time;
	}

	public int getReserved_seats() {
		return reserved_seats;
	}

	public void setReserved_seats(int reserved_seats) {
		this.reserved_seats = reserved_seats;
	}

	public float getSeat_price() {
		return seat_price;
	}

	public void setSeat_price(float seat_price) {
		this.seat_price = seat_price;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public List<FlightBooking> getFlight_bookings() {
		return flight_bookings;
	}

	public void setFlight_bookings(List<FlightBooking> flight_bookings) {
		this.flight_bookings = flight_bookings;
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
		Flight other = (Flight) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", route_id=" + route_id + ", airplane_id=" + airplane_id + ", departure_time="
				+ departure_time + ", reserved_seats=" + reserved_seats + ", seat_price=" + seat_price + ", route="
				+ route + ", airplane=" + airplane + ", flight_bookings=" + flight_bookings + "]";
	}
	
}
