package jhta.band.controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jhta.band.dao.board.BoardDao;
import jhta.band.dao.board.CommentsDao;
import jhta.band.dao.board.ImgBoardDao;
import jhta.band.db.JDBCUtil;
import jhta.band.vo.board.ImgBoardVo;

@WebServlet("/board/boarddelete.do")
public class BoardDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		Long board_num = Long.parseLong(req.getParameter("board_num"));
		
		BoardDao board_dao = new BoardDao();
				
		ImgBoardDao img_dao = new ImgBoardDao();
		
		CommentsDao comments_dao = new CommentsDao();
		
		Connection con = null;
		JSONObject json = new  JSONObject();
		try {
			con = JDBCUtil.getConn();
			con.setAutoCommit(false);
			
			ArrayList<ImgBoardVo> list = img_dao.select(board_num);
			
			int img = img_dao.delete(board_num,con);
			
			if(img >= 0) {
				int comments = comments_dao.delete(board_num, con);
				if(comments >= 0) {
					int board = board_dao.delete(board_num,con);
					if(board > 0) {
						if(list !=null) {
							for(ImgBoardVo vo:list) {
								String src = vo.getImg_url();
								int index = src.indexOf("upload");
								File file = new File(req.getServletContext().getRealPath("/upload") + src.substring(index + 6));
								file.delete();
							}					
						}
						json.put("result", "success");		
					}else {
						con.rollback();
						json.put("result", "fail");
					}
				}else {
					con.rollback();
					json.put("result", "fail");
				}
			}else {
				con.rollback();
				json.put("result", "fail");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			if(con !=null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			JDBCUtil.close(con);
			resp.setContentType("test/palin;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(json);
		}
		
	}
}
