package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.User;

public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	public void add(User u) throws SQLException {
		save("INSERT INTO user (id, role_id, given_name, family_name, username, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", new Object[] {u.getId(), u.getRole_id(), u.getGiven_name(), u.getFamily_name(), u.getUsername(), u.getEmail(), u.getPassword(), u.getPhone()});
	}
	
	public void update(User u) throws SQLException {
		save("UPDATE user SET id = ?, role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? WHERE id = ?", new Object[] {u.getId(), u.getRole_id(), u.getGiven_name(), u.getFamily_name(), u.getUsername(), u.getEmail(), u.getPassword(), u.getPhone(), u.getId()});
	}
	
	public void delete(User u) throws SQLException {
		save("DELETE FROM user WHERE id = ?", new Object[] {u.getId()});
	}
	
	public List<User> readAll() throws SQLException {
		return read("SELECT * FROM user", null);
	}
	
	public User readById(Integer id) throws SQLException {
		return readSingle("SELECT * FROM user WHERE id = ?", new Object[] {id});
	}
	
	protected List<User> extractData(ResultSet rs) throws SQLException {
		List<User> list = new ArrayList<>();
		while(rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setRole_id(rs.getInt("role_id"));
			u.setGiven_name(rs.getString("given_name"));
			u.setFamily_name(rs.getString("family_name"));
			u.setUsername(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setPhone(rs.getString("phone"));
			list.add(u);
		}
		return list;
	}

	protected User extractSingleData(ResultSet rs) throws SQLException {
		if (rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setRole_id(rs.getInt("role_id"));
			u.setGiven_name(rs.getString("given_name"));
			u.setFamily_name(rs.getString("family_name"));
			u.setUsername(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setPhone(rs.getString("phone"));
			return u;
		}
		return null;
	}

}
