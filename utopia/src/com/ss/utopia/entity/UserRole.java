package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class UserRole {

	private int id;
	private String name;
	private List<User> users;
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(int id, String name, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
}
