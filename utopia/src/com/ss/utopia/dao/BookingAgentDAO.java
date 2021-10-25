package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingAgent;

public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}
	
	public void add(BookingAgent ba) throws SQLException {
		save("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?, ?)", new Object[] {ba.getBooking_id(), ba.getAgent_id()});
	}
	
	public void update(BookingAgent ba) throws SQLException {
		save("UPDATE booking_agent SET booking_id = ? AND agent_id = ? WHERE booking_id = ?", new Object[] {ba.getBooking_id(), ba.getAgent_id(), ba.getBooking_id()});
	}
	
	public void delete(BookingAgent ba) throws SQLException {
		save("DELETE FROM booking_agent WHERE booking_id = ?", new Object[] {ba.getBooking_id()});
	}
	
	public List<BookingAgent> readAll() throws SQLException {
		return read("SELECT * FROM booking_agent", null);
	}
	
	public BookingAgent readByBookingId(String booking_id) throws SQLException {
		return readSingle("SELECT * FROM booking_agent WHERE booking_id = ?", new Object[] {booking_id});
	}
	
	public BookingAgent readByAgentId(String agent_id) throws SQLException {
		return readSingle("SELECT * FROM booking_agent WHERE agent_id = ?", new Object[] {agent_id});
	}
	
	protected List<BookingAgent> extractData(ResultSet rs) throws SQLException {
		List<BookingAgent> list = new ArrayList<>();
		while(rs.next()) {
			BookingAgent ba = new BookingAgent();
			ba.setBooking_id(rs.getInt("booking_id"));
			ba.setAgent_id(rs.getInt("agent_id"));
			list.add(ba);
		}
		return list;
	}

	protected BookingAgent extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			BookingAgent ba = new BookingAgent();
			ba.setBooking_id(rs.getInt("booking_id"));
			ba.setAgent_id(rs.getInt("agent_id"));
			return ba;
		}
		return null;
	}

}
