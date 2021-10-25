package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public void add(Passenger p) throws SQLException {
		save("INSERT INTO passenger (id, booking_id, given_name, family_name, dob, gender, address) VALUES (?, ?, ?, ?, ?, ?, ?)", new Object[] {p.getId(), p.getBooking_id(), p.getGiven_name(), p.getFamily_name(), p.getDob(), p.getGender(), p.getAddress()});
	}
	
	public void update(Passenger p) throws SQLException {
		save("UPDATE flight SET id = ?, booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?", new Object[] {p.getId(), p.getBooking_id(), p.getGiven_name(), p.getFamily_name(), p.getDob(), p.getGender(), p.getAddress(), p.getId()});
	}
	
	public void delete(Passenger p) throws SQLException {
		save("DELETE FROM passenger WHERE id = ?", new Object[] {p.getId()});
	}
	
	public List<Passenger> readAll() throws SQLException {
		return read("SELECT * FROM passenger", null);
	}
	
	public Passenger readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM passenger WHERE id = ?", new Object[] {id});
	}
	
	protected List<Passenger> extractData(ResultSet rs) throws SQLException {
		List<Passenger> list = new ArrayList<>();
		while(rs.next()) {
			Passenger p = new Passenger();
			p.setId(rs.getInt("id"));
			p.setBooking_id(rs.getInt("booking_id"));
			p.setGiven_name(rs.getString("given_name"));
			p.setFamily_name(rs.getString("family_name"));
			p.setDob(rs.getDate("dob"));
			p.setGender(rs.getString("gender"));
			p.setAddress(rs.getString("address"));
			list.add(p);
		}
		return list;
	}

	protected Passenger extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Passenger p = new Passenger();
			p.setId(rs.getInt("id"));
			p.setBooking_id(rs.getInt("booking_id"));
			p.setGiven_name(rs.getString("given_name"));
			p.setFamily_name(rs.getString("family_name"));
			p.setDob(rs.getDate("dob"));
			p.setGender(rs.getString("gender"));
			p.setAddress(rs.getString("address"));
			return p;
		}
		return null;
	}

}
