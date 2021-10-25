package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.BookingAgentDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.BookingAgent;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.ConnectionUtil;

public class EmployeeAdmin {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String add(BookingAgent ba, User u) {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO badao = new BookingAgentDAO(conn);
			UserDAO udao = new UserDAO(conn);
			
			List<BookingAgent> list = u.getBooking_agents();
			list.add(ba);
			
			udao.add(u);
			badao.add(ba);
			conn.commit();
			return "Employee added.";
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
				if (u.getRole_id() == 1) {
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
			return "Employee updated";
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
	
	public String delete(BookingAgent ba, User u) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingAgentDAO badao = new BookingAgentDAO(conn);
			UserDAO udao = new UserDAO(conn);
			
			List<BookingAgent> list = u.getBooking_agents();
			list.remove(ba);
			
			badao.delete(ba);
			udao.delete(u);
			conn.commit();
			return "Employee deleted";
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
