package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcTemplate;

public class LoginDAO {
	JdbcTemplate db;
	public LoginDAO() {
		super();
	}
	
	public boolean getLoginUser(String userid,String userpwd) {
		Connection con=db.getConnection();
		PreparedStatement pre=null;
		ResultSet rs=null;
		boolean loginok=false;
		
		try {
			String sql="select * from member2 where userid=? and userpwd=?";
			pre=con.prepareStatement(sql);
			pre.setString(1, userid);
			pre.setString(2, userpwd);
			rs=pre.executeQuery();
			if(rs.next()) {
				loginok=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pre);
			db.close(con);
		}

		return loginok;
	}
	
}
