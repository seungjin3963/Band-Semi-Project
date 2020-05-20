package jhta.band.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jhta.band.db.JDBCUtil;

public class UpdateInfoDao {
	
	public int updateState(long num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update login set login_pwd=? where login_num=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, num);
			int n = pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	public String updatePwd(String pwd, long num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update login set login_pwd=? where login_num=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setLong(2, num);
			pstmt.executeUpdate();
			return pwd;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	
	public String updateEmail(String email, long num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update userinfo set user_email=? where login_num=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setLong(2, num);
			pstmt.executeUpdate();
			return email;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	
	public String updatePhone(String phone, long num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update userinfo set user_phone=? where login_num=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setLong(2, num);
			pstmt.executeUpdate();
			return phone;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	
	public String updateGender(String gender, long num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update userinfo set user_gender=? where login_num=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gender);
			pstmt.setLong(2, num);
			pstmt.executeUpdate();
			return gender;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
	public Date updateBirth(Date birth, long num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update userinfo set user_birth=? where login_num =?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, birth);
			pstmt.setLong(2,num);
			pstmt.executeUpdate();
			return birth;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(null,pstmt,con);
		}
	}
}
