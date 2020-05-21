package jhta.band.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import jhta.band.dao.board.CommentsDao;
import jhta.band.vo.board.CommentsVo;

@WebServlet("/commentsList.do")
public class CommentsListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		Long board_num = Long.parseLong(req.getParameter("board_num"));
		
		int comments_page = Integer.parseInt(req.getParameter("comments_page"));
		
		JSONObject json_origin = new JSONObject();
		
		CommentsDao dao = new CommentsDao();
		int comments_cnt = dao.BoardCount(board_num);
		int maxPage = (int) Math.ceil(comments_cnt/10.0);
		int endPageNum = comments_cnt - ((comments_page-1)*10);
		int startPageNum = endPageNum-9; 
		if(1>startPageNum) {
			startPageNum = 1;
		}
		json_origin.put("comments_cnt", "comments_cnt");
		json_origin.put("maxpage", maxPage);
		
		ArrayList<CommentsVo> list = dao.select(board_num,startPageNum,endPageNum);
		System.out.println(board_num);
		
		if(list != null) {
			JSONArray jarr = new JSONArray();
			for(CommentsVo vo : list) {
				JSONObject json = new JSONObject();
				json.put("comments_num", vo.getComments_num());
				json.put("userband_num", vo.getUserband_num());
				json.put("board_num", vo.getBoard_num());
				json.put("comments_content", vo.getComments_content());
				json.put("ref", vo.getRef());
				json.put("step", vo.getStep());
				json.put("comments_date", vo.getComments_date());
				json.put("comments_state", vo.getComments_state());
				json.put("band_nickname", vo.getBand_nickname());
				jarr.put(json);
			}
			json_origin.put("json", jarr);
			json_origin.put("comments_cnt", comments_cnt);
			
			resp.setContentType("test/palin;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(json_origin);
		}
	}
}
