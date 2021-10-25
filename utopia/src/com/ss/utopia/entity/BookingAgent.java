package com.ss.utopia.entity;

import java.util.Objects;

public class BookingAgent {

	private int booking_id;
	private int agent_id;
	private Booking booking;
	private User user;
	
	public BookingAgent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingAgent(int booking_id, int agent_id, Booking booking, User user) {
		super();
		this.booking_id = booking_id;
		this.agent_id = agent_id;
		this.booking = booking;
		this.user = user;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agent_id, booking_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingAgent other = (BookingAgent) obj;
		return agent_id == other.agent_id && booking_id == other.booking_id;
	}

	@Override
	public String toString() {
		return "BookingAgent [booking_id=" + booking_id + ", agent_id=" + agent_id + ", booking=" + booking + ", user="
				+ user + "]";
	}
	
}
