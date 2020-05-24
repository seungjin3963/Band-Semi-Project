package jhta.band.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhta.band.vo.board.ImgBoardVo;

public class ImgBoardDao {
	
	public ImgBoardVo selectModal(long imgboard_num,long band_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from\n" + 
					"(" + 
					"    select img_url,img_num, lead(img_num) over(order by img_num) next, lag(img_num,1) over(order by img_num) prev from imgboard where band_num=?" + 
					")" + 
					"where img_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, band_num);
			pstmt.setLong(2, imgboard_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ImgBoardVo vo = new ImgBoardVo();
				vo.setImg_url(rs.getString("img_url"));
				vo.setPrevNum(rs.getLong("prev"));
				vo.setNextNum(rs.getLong("next"));
				return vo;
			}else {
				return null;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public int delete(Long board_num,Connection con) {
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "update imgboard set img_states=1 where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, board_num);
			
			return pstmt.executeUpdate();		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	public int delete(String url) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "update imgboard set img_states=1 where img_url=?";
			
			pstmt = con.prepareStatement(sql);
		System.out.println(url);
			pstmt.setString(1, url);
			
			return pstmt.executeUpdate();		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(null, pstmt, con);
		}
	}
	
public int insert(ImgBoardVo vo, Connection con,long board_num) {
		
		PreparedStatement pstmt = null;
		try{
			String sql = "insert into imgboard values(seq_imgboard.nextval,?,?,?,sysdate,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBand_num());
			pstmt.setLong(2, board_num);
			pstmt.setString(3, vo.getImg_url());
			pstmt.setInt(4, vo.getImg_states());
			
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	
	public int insert(ImgBoardVo vo, Connection con) {
		
		PreparedStatement pstmt = null;
		try{
			String sql = "insert into imgboard values(seq_imgboard.nextval,?,seq_board.currval,?,sysdate,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBand_num());
			pstmt.setString(2, vo.getImg_url());
			pstmt.setInt(3, vo.getImg_states());
			
			return pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	public ArrayList<ImgBoardVo> select(long board_num){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from imgboard where board_num=? and img_states!=1";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, board_num);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("Dasdsa");
				return null;
			}
			ArrayList<ImgBoardVo> list = new ArrayList<ImgBoardVo>();
			do {
				ImgBoardVo vo = new ImgBoardVo(
						rs.getLong("img_num"),
						rs.getLong("band_num"),
						rs.getLong("board_num"),
						rs.getString("img_url"),
						rs.getDate("img_regdate"),
						rs.getInt("img_states")
						);
				list.add(vo);
				System.out.println("Sd");
			}while(rs.next());
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
	}
	
public ArrayList<ImgBoardVo> select(long band_num,int startNum, int endNum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from " + 
					"(" + 
					"    select aa.*,rownum rnum from " + 
					"    (" + 
					"        select * from imgboard where band_num=? and img_states!=1 order by img_regdate asc" + 
					"    ) aa" + 
					") where rnum >=? and rnum <=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, band_num);
			pstmt.setInt(2, startNum);
			pstmt.setInt(3, endNum);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			ArrayList<ImgBoardVo> list = new ArrayList<ImgBoardVo>();
			do {
				ImgBoardVo vo = new ImgBoardVo(
						rs.getLong("img_num"),
						rs.getLong("band_num"),
						rs.getLong("board_num"),
						rs.getString("img_url"),
						rs.getDate("img_regdate"),
						rs.getInt("img_states")
						);
				list.add(vo);
				System.out.println("Sd");
			}while(rs.next());
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		
	}
	
	

	public int getImgCount(long band_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(count(img_num),0) cnt from imgboard where band_num=? and img_states!=1";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, band_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			} else {
				return 0;
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(rs, pstmt, con);
		}
	}
}
