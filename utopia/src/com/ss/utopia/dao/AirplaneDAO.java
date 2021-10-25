package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}
	
	public void add(Airplane a) throws SQLException {
		save("INSERT INTO airplane (id, type_id) VALUES (?, ?)", new Object[] {a.getId(), a.getType_id()});
	}
	
	public void update(Airplane a) throws SQLException {
		save("UPDATE airplane SET id = ? AND type_id = ? WHERE id = ?", new Object[] {a.getId(), a.getType_id(), a.getId()});
	}
	
	public void delete(Airplane a) throws SQLException {
		save("DELETE FROM airplane WHERE id = ?", new Object[] {a.getId()});
	}
	
	public List<Airplane> readAll() throws SQLException {
		return read("SELECT * FROM airplane", null);
	}
	
	public Airplane readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM airplane WHERE id = ?", new Object[] {id});
	}

	protected List<Airplane> extractData(ResultSet rs) throws SQLException {
		List<Airplane> list = new ArrayList<>();
		while(rs.next()) {
			Airplane a = new Airplane();
			a.setId(rs.getInt("id"));
			a.setType_id(rs.getInt("type_id"));
			list.add(a);
		}
		return list;
	}

	protected Airplane extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Airplane a = new Airplane();
			a.setId(rs.getInt("id"));
			a.setType_id(rs.getInt("type_id"));
			return a;
		}
		return null;
	}

}
