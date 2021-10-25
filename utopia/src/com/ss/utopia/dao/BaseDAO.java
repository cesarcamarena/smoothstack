package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {
	
	protected static Connection conn = null;
	
	public BaseDAO(Connection conn) {
		//this.conn = conn;
		BaseDAO.conn = conn;
	}
	
	protected Integer saveReturnPK(String sql, Object[] vals) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.execute();
		ResultSet rs = pstmt.getGeneratedKeys();
		while(rs.next()) {
			return rs.getInt(0); //check if this is 0 or 1
		}
		return null;
	}
	
	protected void save(String sql, Object[] vals) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		pstmt.execute();
	}
	
	protected List<T> read(String sql, Object[] vals) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (vals != null) {
			int count = 1;
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}
		return extractData(pstmt.executeQuery());
	}
	
    protected T readSingle(String sql, Object[] values) throws SQLException {
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
	
	protected abstract List<T> extractData(ResultSet rs) throws SQLException;
	protected abstract T extractSingleData(ResultSet rs) throws SQLException;
}
