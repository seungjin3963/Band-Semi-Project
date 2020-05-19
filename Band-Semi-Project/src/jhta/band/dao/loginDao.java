package jhta.band.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhta.band.vo.UserinfoVo;
import jhta.band.vo.loginVo;

public class loginDao {
	
	public String check_id(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select login_id from login where login_id=?";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println("check_id: "+id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String okey = rs.getString("login_id");
				return okey;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	
	// 비밀번호 찾기
	public String findPwd(String id, String answer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select ll.login_pwd "
				+ "from login ll, userinfo uu "
				+ "where ll.login_id=? and uu.user_answer=? "
				+ "and ll.login_num = uu.login_num";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, answer);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pwd = rs.getString("login_pwd");
				return pwd;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	// 퀴즈 찾기
	public String findQuiz(String id, String name, Date birth) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select uu.user_quiz "
				+ "from login ll, userinfo uu "
				+ "where ll.login_id = ? and uu.user_name=? "
				+ "and user_birth=? "
				+ "and ll.login_num=uu.login_num";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, name);
			pstmt.setDate(3, birth);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String quiz = rs.getString("user_quiz");
				return quiz;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	// 이름, 생년월일 입력하고 아이디 찾기
	public String findId(String name, Date birth) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * "
				+ "from login "
				+ "where login_num=(select login_num from userinfo where user_name=? and user_birth=?)";
		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setDate(2, birth);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("login_id");
				return id;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
	}
	public long select(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql1 = "select * from login where login_id=? and login_pwd=?";
		try {
			con = JDBCUtil.getConn();
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, id);
			pstmt1.setString(2, pwd);
			rs = pstmt1.executeQuery();
			if(rs.next()) {
				long num = rs.getLong("login_num");
				return num;
			}return -2;
			
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(con);
		}
	}
	// 회원가입(추가)
	public int insert( loginVo vo1, UserinfoVo vo2) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String sql1 = "insert into login values(?,?,?,sysdate,?)";
		String sql2 = "insert into userinfo values(?,?,?,?,?,?,?,null,?)";
		try {
			con = JDBCUtil.getConn();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setLong(1, vo1.getLogin_num());
			pstmt1.setString(2, vo1.getLogin_id());
			pstmt1.setString(3, vo1.getLogin_pwd());
			pstmt1.setInt(4, vo1.getLogin_state());
			int n1 = pstmt1.executeUpdate();
			if( n1 > 0) {
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setLong(1, vo2.getLogin_num());
				pstmt2.setString(2, vo2.getUser_name());
				pstmt2.setString(3, vo2.getUser_phone());
				pstmt2.setString(4, vo2.getUser_email());
				pstmt2.setString(5, vo2.getUser_gender());
				pstmt2.setString(6, vo2.getUser_quiz());
				pstmt2.setString(7, vo2.getUser_anser());
				pstmt2.setDate(8, vo2.getBirth());
				int n2 = pstmt2.executeUpdate();
				con.commit();
				return n2;
			}else {
				con.rollback();
				return 0;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}finally {
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(con);
		}
	}
}
