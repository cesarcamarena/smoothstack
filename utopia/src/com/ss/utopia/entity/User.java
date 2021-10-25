package com.ss.utopia.entity;

import java.util.List;
import java.util.Objects;

public class User {

	private int id;
	private int role_id;
	private String given_name;
	private String family_name;
	private String username;
	private String email;
	private String password;
	private String phone;
	private List<BookingAgent> booking_agents;
	private List<BookingUser> booking_users;
	private UserRole user_role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, int role_id, String given_name, String family_name, String username, String email,
			String password, String phone, List<BookingAgent> booking_agents, List<BookingUser> booking_users,
			UserRole user_role) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.given_name = given_name;
		this.family_name = family_name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.booking_agents = booking_agents;
		this.booking_users = booking_users;
		this.user_role = user_role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<BookingAgent> getBooking_agents() {
		return booking_agents;
	}

	public void setBooking_agents(List<BookingAgent> booking_agents) {
		this.booking_agents = booking_agents;
	}

	public List<BookingUser> getBooking_users() {
		return booking_users;
	}

	public void setBooking_users(List<BookingUser> booking_users) {
		this.booking_users = booking_users;
	}

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", role_id=" + role_id + ", given_name=" + given_name + ", family_name=" + family_name
				+ ", username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", booking_agents=" + booking_agents + ", booking_users=" + booking_users + ", user_role=" + user_role
				+ "]";
	}
	
}
