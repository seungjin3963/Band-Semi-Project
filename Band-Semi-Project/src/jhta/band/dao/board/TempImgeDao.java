package jhta.band.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhta.band.vo.board.TmpImgVo;

public class TempImgeDao {
	
	
	public int insert(TmpImgVo vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into tmp_imgboard values(seq_tmpimg.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getUserband_num());
			pstmt.setString(2, vo.getTmpimg_url());
			pstmt.setInt(3, vo.getTmp_state());
						
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
	public ArrayList<TmpImgVo> selectList(int userband_num){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from tmp_imgboard where userband_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userband_num);
						
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			
			ArrayList<TmpImgVo> list = new ArrayList<TmpImgVo>();
			do {
				TmpImgVo vo = new TmpImgVo();
				vo.setTmp_num(rs.getInt("tmp_num"));
				vo.setUserband_num(rs.getInt("userband_num"));
				vo.setTmpimg_url(rs.getString("tmpimg_url"));
				vo.setTmp_state(rs.getInt("tmp_state"));
				list.add(vo);				
				
			}while(rs.next());
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
	
	public int delete(TmpImgVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from tmp_imgboard where userband_num=? and tmpimg_url=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getUserband_num());
			pstmt.setString(2, vo.getTmpimg_url());
						
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
	public int delete(int userband_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "delete from tmp_imgboard where userband_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userband_num);
						
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
}
