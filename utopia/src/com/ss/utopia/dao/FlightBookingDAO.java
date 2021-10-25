package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.FlightBooking;

public class FlightBookingDAO extends BaseDAO<FlightBooking> {

	public FlightBookingDAO(Connection conn) {
		super(conn);
	}
	
	public void add(FlightBooking fb) throws SQLException {
		save("INSERT INTO flight_bookings (flight_id, booking_id) VALUES (?, ?)", new Object[] {fb.getFlight_id(), fb.getBooking_id()});
	}
	
	public void update(FlightBooking fb) throws SQLException {
		save("UPDATE flight_bookings SET flight_id = ?, booking_id = ? WHERE flight_id = ?", new Object[] {fb.getFlight_id(), fb.getBooking_id(), fb.getFlight_id()});
	}
	
	public void delete(FlightBooking fb) throws SQLException {
		save("DELETE FROM flight_bookings WHERE flight_id = ?", new Object[] {fb.getFlight_id()});
	}
	
	public List<FlightBooking> readAll() throws SQLException {
		return read("SELECT * FROM flight_bookings", null);
	}
	
	public FlightBooking readByFlightId(Integer flight_id) throws SQLException {
		return readSingle("SELECT * FROM flight_bookings WHERE flight_id = ?", new Object[] {flight_id});
	}
	
	protected List<FlightBooking> extractData(ResultSet rs) throws SQLException {
		List<FlightBooking> list = new ArrayList<>();
		while(rs.next()) {
			FlightBooking fb = new FlightBooking();
			fb.setFlight_id(rs.getInt("flight_id"));
			fb.setBooking_id(rs.getInt("booking_id"));
			list.add(fb);
		}
		return list;
	}

	protected FlightBooking extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			FlightBooking fb = new FlightBooking();
			fb.setFlight_id(rs.getInt("flight_id"));
			fb.setBooking_id(rs.getInt("booking_id"));
			return fb;
		}
		return null;
	}

}
