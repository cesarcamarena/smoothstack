package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.ConnectionUtil;

public class FlightAdmin {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String add(Flight f) {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);			
			fdao.add(f);
			conn.commit();
			return "Flight added.";
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
		List<Flight> flights = null;
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flights = fdao.readAll();
			for (Flight f : flights) {
				System.out.println("Route ID: " + f.getRoute_id());
				System.out.println(f.getRoute().getOrigin_id() + " -> " + f.getRoute().getDestination_id());
				System.out.println("Departure Time: " + new SimpleDateFormat("HH:mm").format(f.getDeparture_time()));
				System.out.println();
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
	
	public String update(Flight f) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.update(f);
			conn.commit();
			return "Flight updated";
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
	
	public String delete(Flight f) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.delete(f);
			conn.commit();
			return "Flight deleted";
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
