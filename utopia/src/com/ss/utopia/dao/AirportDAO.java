package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;

public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection conn) {
		super(conn);
	}
	
	public void add(Airport a) throws SQLException {
		save("INSERT INTO airport (iata_id, city) VALUES (?, ?)", new Object[] {a.getIata_id(), a.getCity()});
	}
	
	public void update(Airport a) throws SQLException {
		save("UPDATE airport SET iata_id = ? AND city = ? WHERE iata_id = ?", new Object[] {a.getIata_id(), a.getCity(), a.getIata_id()});
	}
	
	public void delete(Airport a) throws SQLException {
		save("DELETE FROM airport WHERE iata_id = ?", new Object[] {a.getIata_id()});
	}
	
	public List<Airport> readAll() throws SQLException {
		return read("SELECT * FROM airport", null);
	}
	
	public Airport readById(String iata_id) throws SQLException {
		return readSingle("SELECT * FROM airport WHERE iata_id = ?", new Object[] {iata_id});
	}

	
	protected List<Airport> extractData(ResultSet rs) throws SQLException {
		List<Airport> list = new ArrayList<>();
		while(rs.next()) {
			Airport a = new Airport();
			a.setIata_id(rs.getString("id"));
			a.setCity(rs.getString("city"));
			list.add(a);
		}
		return list;
	}

	protected Airport extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Airport a = new Airport();
			a.setIata_id(rs.getString("id"));
			a.setCity(rs.getString("city"));
			return a;
		}
		return null;
	}

}
