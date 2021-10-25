package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}
	
	public void add(BookingPayment bp) throws SQLException {
		save("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?, ?, ?)", new Object[] {bp.getBooking_id(), bp.getStripe_id(), bp.getRefunded()});
	}
	
	public void update(BookingPayment bp) throws SQLException {
		save("UPDATE booking_payment SET booking_id = ?, stripe_id = ?, refunded = ? WHERE booking_id = ?", new Object[] {bp.getBooking_id(), bp.getStripe_id(), bp.getRefunded(), bp.getBooking_id()});
	}
	
	public void delete(BookingPayment bp) throws SQLException {
		save("DELETE FROM booking_payment WHERE booking_id = ?", new Object[] {bp.getBooking_id()});
	}
	
	public List<BookingPayment> readAll() throws SQLException {
		return read("SELECT * FROM booking_payment", null);
	}
	
	public BookingPayment readByBookingId(Integer booking_id) throws SQLException {
		return readSingle("SELECT * FROM booking_payment WHERE booking_id = ?", new Object[] {booking_id});
	}
	
	protected List<BookingPayment> extractData(ResultSet rs) throws SQLException {
		List<BookingPayment> list = new ArrayList<>();
		while(rs.next()) {
			BookingPayment bp = new BookingPayment();
			bp.setBooking_id(rs.getInt("booking_id"));
			bp.setStripe_id(rs.getString("stripe_id"));
			bp.setRefunded(rs.getShort("refunded"));
			list.add(bp);
		}
		return list;
	}

	protected BookingPayment extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			BookingPayment bp = new BookingPayment();
			bp.setBooking_id(rs.getInt("booking_id"));
			bp.setStripe_id(rs.getString("stripe_id"));
			bp.setRefunded(rs.getShort("refunded"));
			return bp;
		}
		return null;
	}

}
