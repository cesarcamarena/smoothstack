package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.ConnectionUtil;

public class TravelerAdmin {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String add(BookingUser bu, User u) {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			BookingUserDAO budao = new BookingUserDAO(conn);
			UserDAO udao = new UserDAO(conn);
			
			List<BookingUser> list = u.getBooking_users();
			list.add(bu);
			
			udao.add(u);
			budao.add(bu);
			conn.commit();
			return "Traveler added.";
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return "Failed to add";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readAll() {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			List<User> list = udao.readAll();
			
			for (User u : list) {
				if (u.getRole_id() == 2) {
					System.out.println("Name: " + u.getGiven_name() + " " + u.getFamily_name());
					System.out.println("Username: " + u.getUsername());
					System.out.println("Phone: " + u.getPhone());
				}
			}
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String update(User u) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.update(u);
			conn.commit();
			return "Traveler updated";
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return "Failed to update";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String delete(BookingUser bu, User u) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingUserDAO budao = new BookingUserDAO(conn);
			UserDAO udao = new UserDAO(conn);
			List<BookingUser> list = u.getBooking_users();
			list.remove(bu);
			budao.delete(bu);
			udao.delete(u);
			conn.commit();
			return "Traveler deleted";
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return "Failed to delete";
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
