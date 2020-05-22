package jhta.band.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jhta.band.db.JDBCUtil;
import jhta.band.vo.board.CommentsVo;

public class CommentsDao {
	
	public int delete(long board_num,Connection con) {
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update comments set comments_state=1 where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, board_num);
		
			return pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(pstmt);
		}
		
	}
	
	public int delete(long comments_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update comments set comments_state=1 where comments_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, comments_num);
		
			return pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			JDBCUtil.close(null, pstmt, con);
		}
		
	}
	
	public long GetCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(count(comments_num),0) cnt from comments";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getLong("cnt");
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

	public int BoardCount(long board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConn();
			String sql = "select NVL(count(comments_num),0) cnt from comments where board_num=? and comments_state!=1";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, board_num);
			
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
	public int insert(CommentsVo vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into comments values(seq_comments.nextval,?,?,?,?,?,sysdate,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, vo.getUserband_num());
			pstmt.setLong(2, vo.getBoard_num());
			pstmt.setString(3, vo.getComments_content());
			pstmt.setInt(6, vo.getComments_state());
			
			long ref = vo.getRef();
			int step = vo.getStep();
			if(ref == 0) {
				pstmt.setLong(4,GetCount() + 1);;
				pstmt.setInt(5, step);
			}else {
				System.out.println("2222");
				String sql1 = "select max(step) ss from comments where ref=?";
				pstmt1 = con.prepareStatement(sql1);
				
				pstmt1.setLong(1, ref);
				
				rs = pstmt1.executeQuery();
				
				if(!rs.next()) {
					System.out.println("3333");
					pstmt.setLong(4, ref);
					pstmt.setInt(5, rs.getInt("ss")+1);
				}else {
					System.out.println("4444");
					pstmt.setLong(4, ref);
					pstmt.setInt(5, 1);
				}
			}
			
			int n = pstmt.executeUpdate();
			
			return n;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(con);
		}	
	}
	
	
	public ArrayList<CommentsVo> select(long board_num, int startNum,int endNum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from " + 
					" " + 
					"    select aa.*,rownum rnum,bb.band_nickname" + 
					"   from" + 
					"    (" + 
					"        select * from comments where board_num=? and comments_state!=1 order by ref,step" + 
					"    )aa,\" +\r\n" + 
					"    (\" +\r\n" + 
					"        select band_nickname from band_userinfo" + 
					"    )bb" + 
					") "+
					"where rnum >=? and rnum <=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, board_num);
			pstmt.setLong(2, startNum);
			pstmt.setLong(3, endNum);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				return null;
			}
			ArrayList<CommentsVo> list = new ArrayList<CommentsVo>();
			do {
				CommentsVo vo = new CommentsVo(
						rs.getLong("comments_num"), 
						rs.getLong("userband_num"), 
						rs.getLong("board_num"), 
						rs.getString("comments_cotent"), 
						rs.getLong("ref"), 
						rs.getInt("step"), 
						rs.getDate("comments_date"),
						rs.getInt("comments_state")
					);
				vo.setBand_nickname(rs.getString("band_nickname"));
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
