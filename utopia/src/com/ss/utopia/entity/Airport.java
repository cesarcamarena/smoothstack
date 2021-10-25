package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class Airport {

	private String iata_id;
	private String city;
	private List<Route> routes;
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airport(String iata_id, String city, List<Route> routes) {
		super();
		this.iata_id = iata_id;
		this.city = city;
		this.routes = routes;
	}

	public String getIata_id() {
		return iata_id;
	}

	public void setIata_id(String iata_id) {
		this.iata_id = iata_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iata_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		return Objects.equals(iata_id, other.iata_id);
	}

	@Override
	public String toString() {
		return "Airport [iata_id=" + iata_id + ", city=" + city + ", routes=" + routes + "]";
	}
}
