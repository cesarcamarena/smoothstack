package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}
	
	public void add(BookingUser bu) throws SQLException {
		save("INSERT INTO booking_user (booking_id, user_id) VALUES (?, ?)", new Object[] {bu.getBooking_id(), bu.getUser_id()});
	}
	
	public void update(BookingUser bu) throws SQLException {
		save("UPDATE booking_user SET booking_id = ?, user_id = ? WHERE booking_id = ?", new Object[] {bu.getBooking_id(), bu.getUser_id(), bu.getBooking_id()});
	}
	
	public void delete(BookingUser bu) throws SQLException {
		save("DELETE FROM booking_user WHERE booking_id = ?", new Object[] {bu.getBooking_id()});
	}
	
	public List<BookingUser> readAll() throws SQLException {
		return read("SELECT * FROM booking_payment", null);
	}
	
	public BookingUser readByBookingId(Integer booking_id) throws SQLException {
		return readSingle("SELECT * FROM booking_user WHERE booking_id = ?", new Object[] {booking_id});
	}
	
	protected List<BookingUser> extractData(ResultSet rs) throws SQLException {
		List<BookingUser> list = new ArrayList<>();
		while(rs.next()) {
			BookingUser bu = new BookingUser();
			bu.setBooking_id(rs.getInt("booking_id"));
			bu.setUser_id(rs.getInt("user_id"));
			list.add(bu);
		}
		return list;
	}

	protected BookingUser extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			BookingUser bu = new BookingUser();
			bu.setBooking_id(rs.getInt("booking_id"));
			bu.setUser_id(rs.getInt("user_id"));
			return bu;
		}
		return null;
	}

}
