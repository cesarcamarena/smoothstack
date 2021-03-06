package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {
	
	private Connection conn = null;
	
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}
	
	public Integer saveReturnPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.executeUpdate();
//		ResultSet rs = pstmt.getGeneratedKeys();		try this
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			return rs.getInt(1); //try 0
		}
		return null;
	}
	
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.executeUpdate();
	}
	
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
    protected T readSingle(String sql, Object[] values) throws SQLException, ClassNotFoundException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (values != null) {
            int count = 1;
            for (Object o : values) {
                pstmt.setObject(count, o);
                count++;
            }
        }
        return extractSingleData(pstmt.executeQuery());
    }
	
	public abstract List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;
	
	public abstract T extractSingleData(ResultSet rs) throws SQLException, ClassNotFoundException;
}
