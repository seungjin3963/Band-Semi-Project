package jhta.band.dao.band_userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jhta.band.db.JDBCUtil;
import jhth.band.vo.MakeBandVo.Band_userinfoVo;

public class BandUserInfoDao {

	public long selectloginnum(long userband_num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConn();
			pstmt = con.prepareStatement("SELECT LOGIN_NUM FROM BAND_USERINFO WHERE USERBAND_NUM=?");
			pstmt.setLong(1, userband_num);

			rs = pstmt.executeQuery();

			long login_num = 0;

			if (rs.next()) {
				login_num = rs.getLong("login_num");
			}

			return login_num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
