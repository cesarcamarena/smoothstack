package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Route;

public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	public void add(Route r) throws SQLException {
		save("INSERT INTO route (id, origin_id, destination_id) VALUES (?, ?, ?)", new Object[] {r.getId(), r.getOrigin_id(), r.getDestination_id()});
	}
	
	public void update(Route r) throws SQLException {
		save("UPDATE route SET id = ?, origin_id = ?, destination_id = ? WHERE id = ?", new Object[] {r.getId(), r.getOrigin_id(), r.getDestination_id(), r.getId()});
	}
	
	public void delete(Route r) throws SQLException {
		save("DELETE FROM route WHERE id = ?", new Object[] {r.getId()});
	}
	
	public List<Route> readAll() throws SQLException {
		return read("SELECT * FROM route", null);
	}
	
	public Route readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM route WHERE id = ?", new Object[] {id});
	}
	
	protected List<Route> extractData(ResultSet rs) throws SQLException {
		List<Route> list = new ArrayList<>();
		while(rs.next()) {
			Route r = new Route();
			r.setId(rs.getInt("id"));
			r.setOrigin_id(rs.getString("origin_id"));
			r.setDestination_id(rs.getString("destination_id"));
			list.add(r);
		}
		return list;
	}

	protected Route extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Route r = new Route();
			r.setId(rs.getInt("id"));
			r.setOrigin_id(rs.getString("origin_id"));
			r.setDestination_id(rs.getString("destination_id"));
			return r;
		}
		return null;
	}

}
