/**
 * 
 */
package com.hp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 *
 */
public class JDBCUtil {
	
	
	public static final String JDBC_URL = "jdbc_url";
	public static final String DRIVERCLASSNAME = "driverClassName";
	public static final String JDBC_USERNAME = "jdbc_username";
	public static final String JDBC_PASSWORD = "jdbc_password";
	
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public JDBCUtil() {
		try {
			Class.forName(PropertiesUtil.getProperties_2(JDBCUtil.DRIVERCLASSNAME));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		connection = DriverManager.getConnection(PropertiesUtil.getProperties_1(JDBCUtil.JDBC_URL), 
				PropertiesUtil.getProperties_1(JDBCUtil.JDBC_USERNAME), PropertiesUtil.getProperties_1(JDBCUtil.JDBC_PASSWORD));
		
		return connection;
	}
	
	public boolean update(String sql, List<Object> params) throws SQLException {
		
		Connection conn = this.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(i+1, params.get(i));
			}
		}
		
		int i = pstmt.executeUpdate();
		
		return (i > 0)? true : false;
	}
	
	public ResultSet query(String sql, List<Object> params) throws SQLException {
		Connection conn = this.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(i + 1, params.get(i));
			}
		}
		return pstmt.executeQuery();
	}
	
	public void close() throws SQLException {
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (rs != null) {
			rs.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JDBCUtil jdbcUtil = new JDBCUtil();
//		Connection conn = jdbcUtil.getConnection();
//		System.out.println(conn.isClosed());
//		List<Object> params = new ArrayList<>();
//		params.add(UUID.randomUUID().toString().replaceAll("-", ""));
//		boolean update = jdbcUtil.update("insert into Student(id) values(?)", params );
		ResultSet rs = jdbcUtil.query("select * from test", null);
		while (rs.next()) {
			System.out.println("²éÑ¯½á¹û:" + rs.getString(1));
		}
		jdbcUtil.close();
	}

}
