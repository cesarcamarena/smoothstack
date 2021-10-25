package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.ConnectionUtil;

public class PassengerAdmin {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String add(Passenger p) {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.add(p);
			conn.commit();
			return "Passenger added.";
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
			PassengerDAO pdao = new PassengerDAO(conn);
			List<Passenger> list = pdao.readAll();
			
			for (Passenger p : list) {
				System.out.println("Name: " + p.getGiven_name() + " " + p.getFamily_name());
				System.out.println("DOB: " + new SimpleDateFormat("MM/dd/yyyy").format(p.getDob()));
				System.out.println("Gender: " + p.getGender());
				System.out.println("Address: " + p.getAddress());
				System.out.println("Ticket Number: " + p.getBooking().getConfirmation_code());
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
	
	public String update(Passenger p) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.update(p);
			conn.commit();
			return "Passenger updated";
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
	
	public String delete(Passenger p) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.delete(p);
			conn.commit();
			return "Passenger deleted";
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
