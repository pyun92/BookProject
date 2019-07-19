package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcTemplate {

	public static Connection getConnection() {
		Connection conn = null;
		DataSource ds=null;
		
		try {
			Context context=new InitialContext();
			Context env=(Context)context.lookup("java:comp/env");
			ds=(DataSource)env.lookup("jdbc/mysql");
			conn=ds.getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static boolean isConnection(Connection conn) {
		boolean valid = true;
		try {
			if (conn == null || conn.isClosed())
				valid = false;
		} catch (SQLException e) {
			valid = false;
			e.printStackTrace();
		}
		return valid;
	}

	public static void commit(Connection conn) {
		if (isConnection(conn)) {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void rollback(Connection conn) {
		if (isConnection(conn)) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Connection��ü �ݱ�
	public static void close(Connection conn) {
		if (isConnection(conn)) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Statement or PreparedStatement��ü �ݱ�
	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ResultSet ��ü �ݱ�
	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
