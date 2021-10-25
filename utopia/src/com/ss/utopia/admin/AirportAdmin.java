package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.ConnectionUtil;

public class AirportAdmin {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String add(Airport a) {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.add(a);
			conn.commit();
			return "Airport added.";
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
			AirportDAO adao = new AirportDAO(conn);
			List<Airport> list = adao.readAll();
			
			for (Airport a : list) {
				System.out.println(a.getIata_id() + " | " + a.getCity());
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
	
	public String update(Airport a) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.update(a);
			conn.commit();
			return "Airport updated";
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
	
	public String delete(Airport a) {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.delete(a);
			conn.commit();
			return "Airport deleted";
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
