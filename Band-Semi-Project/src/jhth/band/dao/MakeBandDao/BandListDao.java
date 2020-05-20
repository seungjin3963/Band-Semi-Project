package jhth.band.dao.MakeBandDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhth.band.vo.MakeBandVo.BandListVo;

public class BandListDao {
	public ArrayList<BandListVo> band_list(long loginnum){
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		ResultSet rs=null;
		
		ArrayList<BandListVo> bandlist = new ArrayList<BandListVo>();
		
		try {
			con=JDBCUtil.getConn();
			pstmt1=con.prepareStatement("SELECT BAND_NUM FROM BANDLIST WHERE LOGIN_NUM=?");
			pstmt1.setLong(1, loginnum);
			rs=pstmt1.executeQuery();
			while(rs.next()) {
				long band_num = rs.getLong("band_num");
				int bandcnt=0;
				String bandname=null;
				String bandimg=null;
				
				
				pstmt2=con.prepareStatement("SELECT COUNT(?) cnt FROM BANDLIST");
				pstmt2.setLong(1, band_num);
				rs=pstmt2.executeQuery();
				if(rs.next()) {
					bandcnt=rs.getInt("cnt");
				}
				
				pstmt3=con.prepareStatement("SELECT BAND_NAME,BANDIMG FROM BAND ,BANDIMG WHERE BAND.BAND_NUM=? AND BAND.BANDIMGNUM=BANDIMG.BANDIMGNUM");
				pstmt3.setLong(1, band_num);
				rs=pstmt3.executeQuery();
				if(rs.next()) {
					bandname=rs.getString("band_name");
					bandimg=rs.getString("bandimg");
				}
				
				BandListVo vo=new BandListVo(band_num, bandname, bandimg, bandcnt);
				
				bandlist.add(vo);
			}
			
			return bandlist;
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JDBCUtil.close(pstmt3);
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(rs, pstmt1, con);
		}
	}
}
