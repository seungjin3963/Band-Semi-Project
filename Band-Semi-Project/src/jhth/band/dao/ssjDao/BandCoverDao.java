package jhth.band.dao.ssjDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhth.band.vo.ssjVo.CoverVo;

public class BandCoverDao {
	public ArrayList<CoverVo> cover(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<CoverVo> clist=new ArrayList<CoverVo>();
		int startpage=num;
		int endpage=startpage+7;
		int covercount=0;
		
		try {
			con=JDBCUtil.getConn();
			pstmt=con.prepareStatement("SELECT * FROM BANDIMG WHERE BANDIMGNUM>=? AND BANDIMGNUM<=?");
			pstmt.setInt(1, startpage);
			pstmt.setInt(2, endpage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int covernum=rs.getInt("bandimgnum");
				String coverURL=rs.getNString("bandimg");
				
				CoverVo vo=new CoverVo(covercount,covernum, coverURL);
				covercount++;
				
				clist.add(vo);
			}
			
			return clist;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
