package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Flight;

public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	public void add(Flight f) throws SQLException {
		save("INSERT INTO flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?, ?, ?, ?, ?, ?)", new Object[] {f.getId(), f.getRoute_id(), f.getAirplane_id(), f.getDeparture_time(), f.getReserved_seats(), f.getSeat_price()});
	}
	
	public void update(Flight f) throws SQLException {
		save("UPDATE flight SET id = ?, route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?", new Object[] {f.getId(), f.getRoute_id(), f.getAirplane_id(), f.getDeparture_time(), f.getReserved_seats(), f.getSeat_price(), f.getId()});
	}
	
	public void delete(Flight f) throws SQLException {
		save("DELETE FROM flight WHERE id = ?", new Object[] {f.getId()});
	}
	
	public List<Flight> readAll() throws SQLException {
		return read("SELECT * FROM flight", null);
	}
	
	public Flight readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM flight WHERE id = ?", new Object[] {id});
	}
	
	protected List<Flight> extractData(ResultSet rs) throws SQLException {
		List<Flight> list = new ArrayList<>();
		while(rs.next()) {
			Flight f = new Flight();
			f.setId(rs.getInt("id"));
			f.setRoute_id(rs.getInt("route_id"));
			f.setAirplane_id(rs.getInt("airplane_id"));
			f.setDeparture_time(rs.getTimestamp("departure_time"));
			f.setReserved_seats(rs.getInt("reserved_seats"));
			f.setSeat_price(rs.getFloat("seat_price"));
			list.add(f);
		}
		return list;
	}

	protected Flight extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Flight f = new Flight();
			f.setId(rs.getInt("id"));
			f.setRoute_id(rs.getInt("route_id"));
			f.setAirplane_id(rs.getInt("airplane_id"));
			f.setDeparture_time(rs.getTimestamp("departure_time"));
			f.setReserved_seats(rs.getInt("reserved_seats"));
			f.setSeat_price(rs.getFloat("seat_price"));
			return f;
		}
		return null;
	}

}
