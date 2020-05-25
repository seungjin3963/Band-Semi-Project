package jhta.band_main_page_set.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.COMM_FAILURE;

import jhta.band.db.JDBCUtil;

public class bandmainpagesetdao {
	public int mainpagesetting(int num, int val) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update band set BAND_PUBLICWHE=? where band_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,val);
			pstmt.setInt(2,num);
			int n=pstmt.executeUpdate();
			return n;
			}catch(SQLException se) {
				se.printStackTrace();
				
			}finally {
				JDBCUtil.close(null,pstmt,con);
			}
		return -1;
		}	
	
	public int deleteband(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con = JDBCUtil.getConn();
			con.getAutoCommit();
			String sql = "delete from band where band_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			int n=pstmt.executeUpdate();
			
			String sql1 = "delete from bandlist where band_num=?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1,num);
			int b=pstmt1.executeUpdate();
			
				String sql2 = "delete from band_userinfo where band_num=?";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1,num);
				int c=pstmt2.executeUpdate();
			con.commit();
				return c;
				
			
			
			}catch(SQLException se) {
				try {
					con.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				se.printStackTrace();
			}finally {
				JDBCUtil.close(null,pstmt,con);
				try {
				if(pstmt1!=null) {pstmt1.close();}
				if(pstmt2!=null) {pstmt2.close();}
				}catch (SQLException sss) {
				sss.printStackTrace();
				}
			}
		return -1;
		}	
	
	public int bandout(int bandnum,int unum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from band_userinfo where USERBAND_NUM=? and BAND_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,unum);
			pstmt.setInt(2,bandnum);	
			int n=pstmt.executeUpdate();
			return n;
			}catch(SQLException se) {
				se.printStackTrace();		
			}finally {
				JDBCUtil.close(null,pstmt,con);
			}
		return -1;
		}
	
	public int updatecon(int num , String value) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update band set BAND_INTORODUCTIO=? where band_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,value);
			pstmt.setInt(2,num);
			int n=pstmt.executeUpdate();
			return n;
			}catch(SQLException se) {
				se.printStackTrace();
				
			}finally {
				JDBCUtil.close(null,pstmt,con);
			}
		return -1;
		}	
	
	public String sessioncon(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from band where band_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String content=rs.getString("BAND_INTORODUCTIO");
				return content;
			}
			
			}catch(SQLException se) {
				se.printStackTrace();
				
			}finally {
				JDBCUtil.close(rs,pstmt,con);
			}
		return null;
		}	
	
	public int bandlistdout(int bandnum , long loginnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from bandlist where BAND_NUM=? and LOGIN_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bandnum);
			pstmt.setLong(2,loginnum);
			int n=pstmt.executeUpdate();
			return n;
			}catch(SQLException se) {
				se.printStackTrace();
				
			}finally {
				JDBCUtil.close(null,pstmt,con);
			}
		return -1;
	}
}
	


















