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
		ResultSet rs1=null;
		ResultSet rs2=null;
		
		ArrayList<BandListVo> bandlist = new ArrayList<BandListVo>();
		
		try {
			con=JDBCUtil.getConn();
			pstmt1=con.prepareStatement("SELECT BAND_NUM FROM BANDLIST WHERE LOGIN_NUM=?");
			pstmt1.setLong(1, loginnum);
			rs1=pstmt1.executeQuery();
			while(rs1.next()) {
				long band_num = rs1.getLong("band_num");
				long bandcnt=0;
				String bandname=null;
				String bandimg=null;
				
				
				pstmt2=con.prepareStatement("SELECT COUNT(BAND_NUM) cnt FROM BANDLIST WHERE BAND_NUM=?");
				pstmt2.setLong(1, band_num);
				rs2=pstmt2.executeQuery();
				if(rs2.next()) {
					bandcnt=rs2.getLong("cnt");
				}
				
				pstmt3=con.prepareStatement("SELECT BAND_NAME,BANDIMG FROM BAND ,BANDIMG WHERE BAND.BAND_NUM=? AND BAND.BANDIMGNUM=BANDIMG.BANDIMGNUM");
				pstmt3.setLong(1, band_num);
				rs2=pstmt3.executeQuery();
				if(rs2.next()) {
					bandname=rs2.getString("band_name");
					bandimg=rs2.getString("bandimg");
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
			JDBCUtil.close(rs2);
			JDBCUtil.close(rs1, pstmt1, con);
		}
	}
}
