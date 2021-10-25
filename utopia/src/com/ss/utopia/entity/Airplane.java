package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class Airplane {

	private int id;
	private int type_id;
	private AirplaneType airplane_type;
	private List<Flight> flights;
	
	public Airplane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airplane(int id, int type_id, AirplaneType airplane_type, List<Flight> flights) {
		super();
		this.id = id;
		this.type_id = type_id;
		this.airplane_type = airplane_type;
		this.flights = flights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public AirplaneType getAirplane_type() {
		return airplane_type;
	}

	public void setAirplane_type(AirplaneType airplane_type) {
		this.airplane_type = airplane_type;
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
		Airplane other = (Airplane) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", type_id=" + type_id + ", airplane_type=" + airplane_type + ", flights="
				+ flights + "]";
	}
	
}
