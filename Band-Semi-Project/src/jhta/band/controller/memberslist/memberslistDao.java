package jhta.band.controller.memberslist;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;


public class memberslistDao {
	public ArrayList<String> bandmembersSelect(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
				con=JDBCUtil.getConn();
				String sql="select * from(select * from band_userinfo where band_num=?) where BAND_APPROVED=1 or BAND_APPROVED=2";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				ArrayList<String> list=new ArrayList<String>();
				rs=pstmt.executeQuery();
				while(rs.next()) {
					String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
					list.add(BAND_NICKNAME);
				}
				return list;
				
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}finally {
				try {
				if(rs!=null) {rs.close();}
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}
				}catch(SQLException see) {
					System.out.println(see.getMessage());
			}
		}
			return null;
	}
	
	public ArrayList<String> likeselect(String text , int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			
			String sql="select * from (select * from band_userinfo where band_nickname like '%' || ? || '%' and (BAND_APPROVED=1 or BAND_APPROVED=2) and BAND_NUM=?) ORDER by band_nickname";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setInt(2, num);
			ArrayList<String> list=new ArrayList<String>();
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
				list.add(BAND_NICKNAME);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			}catch(SQLException see) {
				System.out.println(see.getMessage());
		}
	}
		return null;
		
		
	}
	
	public ArrayList<String> regdateselect(String text , int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			
			String sql="select * from (select * from band_userinfo where band_nickname like '%' || ? || '%' and (BAND_APPROVED=1 or BAND_APPROVED=2) and  BAND_NUM=?) ORDER by band_redate";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, text);
			
			pstmt.setInt(2, num);
			ArrayList<String> list=new ArrayList<String>();
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
				list.add(BAND_NICKNAME);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			}catch(SQLException see) {
				System.out.println(see.getMessage());
		}
	}
		return null;
		
		
	}
	
	public ArrayList<String> memberscheck(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from band_userinfo where band_num=? and band_approved=3";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			ArrayList<String> list=new ArrayList<String>();
			while(rs.next()) {
				String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
				list.add(BAND_NICKNAME);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			}catch(SQLException see) {
				System.out.println(see.getMessage());
		}
	}
		return null;
	}
	public int updateapproved1(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}finally {
			try {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			}catch(SQLException see) {
				System.out.println(see.getMessage());
		}
	}
		return -1;
	}
}









