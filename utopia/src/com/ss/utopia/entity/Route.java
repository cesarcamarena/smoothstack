package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class Route {

	private int id;
	private String origin_id;
	private String destination_id;
	private Airport airport;
	private List<Flight> flights;
	
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(int id, String origin_id, String destination_id, Airport airport, List<Flight> flights) {
		super();
		this.id = id;
		this.origin_id = origin_id;
		this.destination_id = destination_id;
		this.airport = airport;
		this.flights = flights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}

	public String getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(String destination_id) {
		this.destination_id = destination_id;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
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
		Route other = (Route) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", origin_id=" + origin_id + ", destination_id=" + destination_id + ", airport="
				+ airport + ", flights=" + flights + "]";
	}
	
}
