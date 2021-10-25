package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.ConnectionUtil;

public class SeatAdmin {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String add(int id) {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			Flight f = fdao.readById(id);
			int max = f.getAirplane().getAirplane_type().getMax_capacity();
			int reserved = f.getReserved_seats();
			
			if (reserved == max) {
				return "Flight is full.";
			}
			
			f.setReserved_seats(reserved + 1);
			fdao.update(f);
			conn.commit();
			return "Seat added.";
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
	
	public void readAll(int id) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			Flight f = fdao.readById(id);
			int max = f.getAirplane().getAirplane_type().getMax_capacity();
			int reserved = f.getReserved_seats();
			System.out.println("Reserved Seats: " + reserved + " | Available Seats: " + (max - reserved));
			
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
	
	public String update(int id, float price) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			Flight f = fdao.readById(id);
			f.setSeat_price(price);
			fdao.update(f);
			conn.commit();
			return "Seat price updated";
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
	
	public String delete(int id) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			Flight f = fdao.readById(id);
			
			int reserved = f.getReserved_seats();
			
			if (reserved == 0) {
				return "No seats to delete.";
			}
			
			f.setReserved_seats(reserved - 1);
			fdao.update(f);
			conn.commit();
			return "Seat deleted";
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
