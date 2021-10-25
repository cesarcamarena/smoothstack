package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}
	
	public void add(BookingGuest bg) throws SQLException {
		save("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) VALUES (?, ?, ?)", new Object[] {bg.getBooking_id(), bg.getContact_email(), bg.getContact_phone()});
	}
	
	public void update(BookingGuest bg) throws SQLException {
		save("UPDATE booking_guest SET booking_id = ?, contact_email = ?, contact_phone = ? WHERE booking_id = ?", new Object[] {bg.getBooking_id(), bg.getContact_email(), bg.getContact_phone(), bg.getBooking_id()});
	}
	
	public void delete(BookingGuest bg) throws SQLException {
		save("DELETE FROM booking_guest WHERE booking_id = ?", new Object[] {bg.getBooking_id()});
	}
	
	public List<BookingGuest> readAll() throws SQLException {
		return read("SELECT * FROM booking_guest", null);
	}
	
	public BookingGuest readByBookingId(Integer booking_id) throws SQLException {
		return readSingle("SELECT * FROM booking_guest WHERE booking_id = ?", new Object[] {booking_id});
	}
	
	protected List<BookingGuest> extractData(ResultSet rs) throws SQLException {
		List<BookingGuest> list = new ArrayList<>();
		while(rs.next()) {
			BookingGuest bg = new BookingGuest();
			bg.setBooking_id(rs.getInt("booking_id"));
			bg.setContact_email(rs.getString("contact_email"));
			bg.setContact_phone(rs.getString("contact_phone"));
			list.add(bg);
		}
		return list;
	}

	protected BookingGuest extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			BookingGuest bg = new BookingGuest();
			bg.setBooking_id(rs.getInt("booking_id"));
			bg.setContact_email(rs.getString("contact_email"));
			bg.setContact_phone(rs.getString("contact_phone"));
			return bg;
		}
		return null;
	}

}
