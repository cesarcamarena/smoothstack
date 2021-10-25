package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	public void add(UserRole ur) throws SQLException {
		save("INSERT INTO user_role (id, name) VALUES (?, ?)", new Object[] {ur.getId(), ur.getName()});
	}
	
	public void update(UserRole ur) throws SQLException {
		save("UPDATE user_role SET id = ?, name = ? WHERE id = ?", new Object[] {ur.getId(), ur.getName()});
	}
	
	public void delete(UserRole ur) throws SQLException {
		save("DELETE FROM user_role WHERE id = ?", new Object[] {ur.getId()});
	}
	
	public List<UserRole> readAll() throws SQLException {
		return read("SELECT * FROM user_role", null);
	}
	
	public UserRole readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM user_role WHERE id = ?", new Object[] {id});
	}
	
	protected List<UserRole> extractData(ResultSet rs) throws SQLException {
		List<UserRole> list = new ArrayList<>();
		while(rs.next()) {
			UserRole ur = new UserRole();
			ur.setId(rs.getInt("id"));
			ur.setName(rs.getString("name"));
			list.add(ur);
		}
		return list;
	}

	protected UserRole extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			UserRole ur = new UserRole();
			ur.setId(rs.getInt("id"));
			ur.setName(rs.getString("name"));
			return ur;
		}
		return null;
	}

}
