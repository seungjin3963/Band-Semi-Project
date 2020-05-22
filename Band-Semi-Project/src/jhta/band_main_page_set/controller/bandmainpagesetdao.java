package jhta.band_main_page_set.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				
				return c;
				
			
			
			}catch(SQLException se) {
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
	}

















