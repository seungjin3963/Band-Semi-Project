package jhta.band.controller.calender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CalenderDao {
	public int CalenderInsert(CalenderDvo vo) {
		int calender_n=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=jhta.band.db.JDBCUtil.getConn();
			String sql="insert into calendar values(?,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getCalender_num());
			pstmt.setInt(2, vo.getBand_num());
			pstmt.setString(4, vo.getCalender_title());
			pstmt.setString(3, vo.getCalender_date());
			pstmt.setString(5, vo.getCalender_content());
			calender_n=pstmt.executeUpdate();
			return calender_n;
		}catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return -1;
	}
}
