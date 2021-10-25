package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Booking;

public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}
	
	public void add(Booking b) throws SQLException {
		save("INSERT INTO booking (id, is_active, confirmation_code) VALUES (?, ?, ?)", new Object[] {b.getId(), b.getIs_active(), b.getConfirmation_code()});
	}
	
	public void update(Booking b) throws SQLException {
		save("UPDATE booking SET id = ?, is_active = ?, confirmation_code = ? WHERE id = ?", new Object[] {b.getId(), b.getIs_active(), b.getConfirmation_code(), b.getId()});
	}
	
	public void delete(Booking b) throws SQLException {
		save("DELETE FROM booking WHERE id = ?", new Object[] {b.getId()});
	}
	
	public List<Booking> readAll() throws SQLException {
		return read("SELECT * FROM booking", null);
	}
	
	public Booking readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM booking WHERE id = ?", new Object[] {id});
	}
	
	protected List<Booking> extractData(ResultSet rs) throws SQLException {
		List<Booking> list = new ArrayList<>();
		while(rs.next()) {
			Booking b = new Booking();
			b.setId(rs.getInt("id"));
			b.setIs_active(rs.getShort("is_active"));
			b.setConfirmation_code(rs.getString("confirmation_code"));
			list.add(b);
		}
		return list;
	}

	protected Booking extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Booking b = new Booking();
			b.setId(rs.getInt("id"));
			b.setIs_active(rs.getShort("is_active"));
			b.setConfirmation_code(rs.getString("confirmation_code"));
			return b;
		}
		return null;
	}

}
