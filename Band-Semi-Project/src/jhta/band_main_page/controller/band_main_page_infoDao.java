package jhta.band_main_page.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import jhta.band.db.JDBCUtil;

public class band_main_page_infoDao {
	public BandInfoDvo b_m_p_info(int bandnum ,int loginnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from band_userinfo where login_num=? and band_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,loginnum);
			pstmt.setInt(2, bandnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int user_Band_num = rs.getInt("USERBAND_NUM");
				int band_approved = rs.getInt("BAND_APPROVED");
				BandInfoDvo dvo=new BandInfoDvo(band_approved, user_Band_num);
			
				return dvo;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs,pstmt,con);
		}
		return null;
	}
		public BandAllinfoDvo bandAllinfo(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = JDBCUtil.getConn();
				String sql = "select c.bandimg , a.* from (select * from band where band_num=?)a , bandimg c where a.bandimgnum = c.bandimgnum";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String bandimg = rs.getString("bandimg");
					String band_name=rs.getString("band_name");
					String band_intoroductio=rs.getString("band_intoroductio");
					BandAllinfoDvo dvo=new BandAllinfoDvo(band_name, band_intoroductio, bandimg);
					return dvo;
				}
			}catch(SQLException se) {
				se.printStackTrace();
				return null;
			}finally {
				JDBCUtil.close(rs,pstmt,con);
			}
			return null;
		}
		/*public int memberscount(int num) {
			
		}*/
		
	}

