package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class AirplaneType {

	private int id;
	private int max_capacity;
	private List<Airplane> airplanes;
	
	public AirplaneType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirplaneType(int id, int max_capacity, List<Airplane> airplanes) {
		super();
		this.id = id;
		this.max_capacity = max_capacity;
		this.airplanes = airplanes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
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
		AirplaneType other = (AirplaneType) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "AirplaneType [id=" + id + ", max_capacity=" + max_capacity + ", airplanes=" + airplanes + "]";
	}
	
}
