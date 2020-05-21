package jhta.band.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhta.band.vo.board.BoardVo;
import jhta.band.vo.board.ImgBoardVo;
import jhta.band.vo.board.TmpImgVo;

public class BoardDao {
	
	public int delete(long board_num, Connection con) {
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "update board set board_states=2 where board_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, board_num);
			
			return pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(pstmt);
		}
		
	}
	
	public int update(BoardVo bvo, ArrayList<TmpImgVo> ivo){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = JDBCUtil.getConn();
			String sql = "update board set board_content=? where board_num=?";
			
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoard_content());
			pstmt.setLong(2,bvo.getBoard_num());
			
			int n = pstmt.executeUpdate();
			
			ImgBoardDao dao = new ImgBoardDao();
			
			if(ivo != null) {				
				for(TmpImgVo vo : ivo) {
					System.out.println("stat: " +vo.getTmp_state());
					if(vo.getTmp_state() == 1) {
						dao.delete(vo.getTmpimg_url());					
						if(n<=0) {
							con.rollback();
							return -1;
						}	
					}else {
						ImgBoardVo img = new ImgBoardVo(
								0, bvo.getBand_num(), bvo.getBoard_num(), vo.getTmpimg_url(), null, 0);
						int result = dao.insert(img,con,bvo.getBoard_num());
						if(result <=0) {
							System.out.println("qweqw");
							con.rollback();
							return -1;
						}
					}
				}
			}
			con.commit();

			return n;
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return -1;
			}
			return -1;
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}	
		
	}
	public int insertSet(BoardVo bvo, ArrayList<TmpImgVo> ivo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into board values(seq_board.nextval,?,?,?,sysdate,?)";
			
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, bvo.getBand_num());
			pstmt.setLong(2, bvo.getUserband_num());
			pstmt.setString(3, bvo.getBoard_content());
			pstmt.setInt(4,bvo.getBoard_states());
			
			int n = pstmt.executeUpdate();
			
			ImgBoardDao dao = new ImgBoardDao();
			
			if(ivo != null) {				
				for(TmpImgVo vo : ivo) {
					System.out.println("Asdsa");
					ImgBoardVo img = new ImgBoardVo(
							0, bvo.getBand_num(), bvo.getBoard_num(), vo.getTmpimg_url(), null, 0);
					int result = dao.insert(img,con);
					if(result <=0) {
						con.rollback();
						return -1;
					}
				}
			}
			con.commit();

			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return -1;
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}	
	}
	
	
	public ArrayList<BoardVo> select(int band_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from board where band_num=? and board_states!=2 order by board_redate DESC ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, band_num);
						
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			ArrayList<BoardVo> list = new ArrayList<BoardVo>();
			do{
				BoardVo vo = new BoardVo
						(
								rs.getLong("board_num"), 
								rs.getLong("band_num"), 
								rs.getLong("userband_num"), 
								rs.getString("board_content"), 
								rs.getDate("board_redate"), 
								rs.getInt("board_states")
						);
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
}
