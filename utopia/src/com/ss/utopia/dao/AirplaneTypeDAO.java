package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}
	
	public void add(AirplaneType at) throws SQLException {
		save("INSERT INTO airplane_type (id, max_capacity) VALUES (?, ?)", new Object[] {at.getId(), at.getMax_capacity()});
	}
	
	public void update(AirplaneType at) throws SQLException {
		save("UPDATE airplane_type SET id = ? AND max_capacity = ? WHERE id = ?", new Object[] {at.getId(), at.getMax_capacity(), at.getId()});
	}
	
	public void delete(AirplaneType at) throws SQLException {
		save("DELETE FROM airplane_type WHERE id = ?", new Object[] {at.getId()});
	}
	
	public List<AirplaneType> readAll() throws SQLException {
		return read("SELECT * FROM airplane_type", null);
	}
	
	public AirplaneType readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM airplane_type WHERE id = ?", new Object[] {id});
	}

	protected List<AirplaneType> extractData(ResultSet rs) throws SQLException {
		List<AirplaneType> list = new ArrayList<>();
		while(rs.next()) {
			AirplaneType at = new AirplaneType();
			at.setId(rs.getInt("id"));
			at.setMax_capacity(rs.getInt("max_capacity"));
			list.add(at);
		}
		return list;
	}

	protected AirplaneType extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			AirplaneType at = new AirplaneType();
			at.setId(rs.getInt("id"));
			at.setMax_capacity(rs.getInt("max_capacity"));
			return at;
		}
		return null;
	}

}
