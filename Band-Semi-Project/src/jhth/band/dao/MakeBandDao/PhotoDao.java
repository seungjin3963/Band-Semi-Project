package jhth.band.dao.MakeBandDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhth.band.vo.MakeBandVo.PhotoVo;

public class PhotoDao {
	public int imgInput(String location,long loginnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		FileInputStream fis = null;
		File file = new File(location);
		try {
			fis = new FileInputStream(file);

			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement("UPDATE USERINFO SET USER_IMG=? WHERE LOGIN_NUM = ?");
			pstmt.setBinaryStream(1, fis, file.length());
			pstmt.setLong(2, loginnum);

			int n = pstmt.executeUpdate();

			return n;
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
			JDBCUtil.close(null, pstmt, con);
		}
	}

	public ArrayList<PhotoVo> imgOutput() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		File data=null; 

		ArrayList<PhotoVo> list = new ArrayList<PhotoVo>();

		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement("SELECT * FROM BCATEGORY");
			rs = pstmt.executeQuery();
			
			byte [] temp = new byte[1024]; 
			int cnt=0;
			while (rs.next()) {
				int bcategorynum = rs.getInt("bcategorynum");
				String bcategory_btitle = rs.getString("category_btitle");
				byte[] categoryimg=rs.getBytes("categoryimg");
				PhotoVo vo=new PhotoVo(bcategorynum, bcategory_btitle, categoryimg);
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
