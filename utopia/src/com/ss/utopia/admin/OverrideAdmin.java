package com.ss.utopia.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.BookingPaymentDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingPayment;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.ConnectionUtil;

public class OverrideAdmin {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	public String override(Booking b) {
		
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			BookingPaymentDAO bpdao = new BookingPaymentDAO(conn);
			PassengerDAO pdao = new PassengerDAO(conn);
			
			BookingPayment bp = b.getBooking_payment();
			bp.setRefunded((short) 1);
			
			Passenger p = null;
			List<Passenger> list = b.getPassengers();
			for (Passenger pass : list) {
				if (p.getBooking_id() == b.getId()) {
					p = pass;
				}
			}
			list.remove(p);
			
			b.setIs_active((short) 0);
			
			bdao.update(b);
			bpdao.update(bp);
			pdao.delete(p);
			conn.commit();
			return "Override successful.";
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return "Failed to override";
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
