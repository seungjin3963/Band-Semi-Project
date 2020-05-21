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
	public ArrayList<mainpagemembersDvo> bandmembersSelect(int num) {
		int a=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
				con=JDBCUtil.getConn();
				String sql="select * from(select * from band_userinfo where band_num=?) where BAND_APPROVED=1 or BAND_APPROVED=2";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num);
				ArrayList<mainpagemembersDvo> list=new ArrayList<mainpagemembersDvo>();
				rs=pstmt.executeQuery();
				while(rs.next()) {
					a+=1;
					String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
					int usernum=rs.getInt("USERBAND_NUM");
					mainpagemembersDvo vo=new mainpagemembersDvo(BAND_NICKNAME, usernum,a);
					list.add(vo);
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
	
	public ArrayList<mainpagemembersDvo> likeselect(String text , int num){
		int a=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			
			String sql="select * from (select * from band_userinfo where band_nickname like '%' || ? || '%' and (BAND_APPROVED=1 or BAND_APPROVED=2) and BAND_NUM=?) ORDER by band_nickname";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setInt(2, num);
			ArrayList<mainpagemembersDvo> list=new ArrayList<mainpagemembersDvo>();
			rs=pstmt.executeQuery();
			while(rs.next()) {
				a+=1;
				String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
				int usernum=rs.getInt("USERBAND_NUM");
				mainpagemembersDvo vo=new mainpagemembersDvo(BAND_NICKNAME, usernum,a);
				list.add(vo);
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
	
	public ArrayList<mainpagemembersDvo> regdateselect(String text , int num){
		int a=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			
			String sql="select * from (select * from band_userinfo where band_nickname like '%' || ? || '%' and (BAND_APPROVED=1 or BAND_APPROVED=2) and  BAND_NUM=?) ORDER by band_redate";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, text);
			
			pstmt.setInt(2, num);
			ArrayList<mainpagemembersDvo> list=new ArrayList<mainpagemembersDvo>();
			rs=pstmt.executeQuery();
			while(rs.next()) {
				a+=1;
				String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
				int usernum=rs.getInt("USERBAND_NUM");
				mainpagemembersDvo vo=new mainpagemembersDvo(BAND_NICKNAME, usernum,a);
				list.add(vo);
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
	
	public ArrayList<mainpagemembersDvo> memberscheck(int num){
		int a=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="select * from band_userinfo where band_num=? and band_approved=3";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			ArrayList<mainpagemembersDvo> list=new ArrayList<mainpagemembersDvo>();
			while(rs.next()) {
				a+=1;
				String BAND_NICKNAME=rs.getString("BAND_NICKNAME");
				int usernum=rs.getInt("USERBAND_NUM");
				mainpagemembersDvo vo=new mainpagemembersDvo(BAND_NICKNAME, usernum,a);
				list.add(vo);
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
	public int updateapproved1(String name, int unum ,int bnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="update band_userinfo set band_approved=2 where band_nickname=? and band_num=? and USERBAND_NUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, bnum);
			pstmt.setInt(3, unum);
			int n=pstmt.executeUpdate();
			return n;
			
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
	
	public int updateapproved2(String name, int unum ,int bnum) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getConn();
			String sql="delete from band_userinfo where band_nickname=? and band_num=? and USERBAND_NUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, bnum);
			pstmt.setInt(3, unum);
			int n=pstmt.executeUpdate();
			
			return n;
			
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









