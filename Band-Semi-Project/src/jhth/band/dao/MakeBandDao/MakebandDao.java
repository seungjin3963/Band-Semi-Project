package jhth.band.dao.MakeBandDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jhta.band.db.JDBCUtil;
import jhth.band.vo.MakeBandVo.MakebandVo;
import oracle.jdbc.OracleConnection.CommitOption;

public class MakebandDao {
	public int makeband(MakebandVo vo,long loginNum,String username) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		ResultSet rs=null;

		int g=0;
		int f=0;
		long num=0;

		try {
			con=JDBCUtil.getConn();
			
			pstmt1=con.prepareStatement("INSERT INTO BAND VALUES(SEQ_BAND.NEXTVAL,?,?,?,?,?,SYSDATE,1)");
			pstmt1.setInt(1, vo.getScategoryNum());
			pstmt1.setInt(2, vo.getBand_imgNum());
			pstmt1.setString(3, vo.getBand_name());
			pstmt1.setInt(4, vo.getBand_publicwhe());
			pstmt1.setString(5,vo.getBand_introductio());
			
			int n=pstmt1.executeUpdate();
			
			pstmt2=con.prepareStatement("SELECT BAND_NUM FROM BAND ORDER BY BAND_NUM DESC");
			rs=pstmt2.executeQuery();
			if(rs.next()) {
				num=rs.getLong("band_num");
			}
			
			if(n>0 && num>0) {
				
				f=bandinfo(num,loginNum,username);
				if(f>0) {
					g=bandListinfo(num, loginNum);
				}
			}
			
			return g;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(rs , pstmt2, null);
			JDBCUtil.close(null, pstmt1, con);
		}
	}
	
	public int bandinfo(long num,long loginNum,String username) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String bandleader=username;
		
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("INSERT INTO BAND_USERINFO VALUES(BANDUSERINFO_SEQ.NEXTVAL,?,?,?,1,SYSDATE)");
			pstmt.setLong(1, num);
			pstmt.setLong(2, loginNum);
			pstmt.setString(3, bandleader);
			int n=pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
	public int bandListinfo(long num,long loginNum) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("INSERT INTO BANDLIST VALUES(SEQ_BANDLIST.NEXTVAL,?,?,1,SYSDATE)");
			pstmt.setLong(1, num);
			pstmt.setLong(2, loginNum);
			int n=pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
	public int bandDel(long band_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("UPDATE BAND SET BAND_STATES=2 WHERE BAND_NUM=?");
			pstmt.setLong(1, band_num);
			
			int n=pstmt.executeUpdate();
			
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
}
