package jhth.band.dao.MakeBandDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jhta.band.db.JDBCUtil;

public class ProfileDao {
	public int imgInput(String location,long loginnum) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		FileInputStream fis = null;
		File file = new File(location);
		try {
			fis = new FileInputStream(file);

			con = JDBCUtil.getConn();
			pstmt1=con.prepareStatement("UPDATE USERINFO SET USER_IMG=? WHERE LOGIN_NUM=?");
			pstmt1.setString(1, "change");
			pstmt1.setLong(2, loginnum);
			
			int m=pstmt1.executeUpdate();
			
			if(m>0) {
				pstmt2 = con.prepareStatement("UPDATE PROFILEDATA SET USER_IMGDATA=? WHERE LOGIN_NUM=?");
				pstmt2.setBinaryStream(1, fis, file.length());
				pstmt2.setLong(2, loginnum);
	
				int n = pstmt2.executeUpdate();

				return n;
			}else {
				return -1;
			}
		} catch (FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			return -1;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ie) {
				System.out.println(ie.getMessage());
			}
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(null, pstmt1, con);
		}
	}

	public byte[] imgOutput(long loginnum) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 =null;
		ResultSet rs2 = null;
		
		byte[] user_img=null;
		
		try {
			con = JDBCUtil.getConn();
			pstmt1=con.prepareStatement("SELECT USER_IMG FROM USERINFO WHERE LOGIN_NUM=?");
			pstmt1.setLong(1, loginnum);
			rs1=pstmt1.executeQuery();
			String on=null;
			if(rs1.next()) {
				on=rs1.getString("user_img");
			}
			
			if(on != null) {
				
				pstmt2 = con.prepareStatement("SELECT USER_IMGDATA FROM PROFILEDATA WHERE LOGIN_NUM=?");
				pstmt2.setLong(1, loginnum);
				rs2 = pstmt2.executeQuery();
				
				if (rs2.next()) {
					user_img=rs2.getBytes("user_imgdata");
				}
			}else {
				pstmt2 = con.prepareStatement("SELECT USER_IMGDATA FROM PROFILEDATA WHERE PROFILE_NUM=?");
				pstmt2.setLong(1, 9999);
				rs2 = pstmt2.executeQuery();
				
				if (rs2.next()) {
					user_img=rs2.getBytes("user_imgdata");
				}
			}
			return user_img;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			JDBCUtil.close(rs2, pstmt2, null);
			JDBCUtil.close(rs1, pstmt1, con);
		}
	}
}
