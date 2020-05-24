package jhta.band.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import jhta.band.dao.board.BoardDao;
import jhta.band.dao.board.CommentsDao;
import jhta.band.vo.board.BoardVo;
import jhta.band.vo.board.CommentsVo;

@WebServlet("/boardModal.do")
public class BoardModalController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		long board_num = Long.parseLong(req.getParameter("board_num"));
		long band_num = Long.parseLong(req.getParameter("band_num"));
		
		System.out.println(board_num);
		System.out.println(band_num);
		BoardDao board_dao = new BoardDao();
		
		BoardVo board_vo = board_dao.selectModal(board_num, band_num);
		
		if(board_vo == null) {
			System.out.println("1111111");
		}
		int comments_page = Integer.parseInt(req.getParameter("comments_page"));
		
		JSONObject json = new JSONObject();
		SimpleDateFormat fm=new SimpleDateFormat("yyyy³â MM¿ù dd a hh:mm"); 
		System.out.println(board_vo.getBoard_num());
		json.put("band_num", board_vo.getBand_num());
		json.put("board_num", board_vo.getBoard_num());
		json.put("board_states", board_vo.getBoard_states());
		json.put("userband_num", board_vo.getUserband_num());
		json.put("board_content", board_vo.getBoard_content());
	     
		String sDate=fm.format(board_vo.getBoard_redate()); 

		json.put("board_redate", sDate);
		json.put("band_nickname", board_vo.getBand_nickname());
		json.put("prevNum", board_vo.getNextNum());
		json.put("nextNum", board_vo.getPrevNum());
		
		
		CommentsDao dao = new CommentsDao();
		int comments_cnt = dao.BoardCount(board_num);
		int maxPage = (int) Math.ceil(comments_cnt/10.0);
		int endPageNum = comments_cnt - ((comments_page-1)*10);
		int startPageNum = endPageNum-9; 
		if(1>startPageNum) {
			startPageNum = 1;
		}
		
		ArrayList<CommentsVo> list = dao.select(board_num,startPageNum,endPageNum);
		System.out.println(board_num);
		if(list != null) {
			JSONArray jarr = new JSONArray();
			for(CommentsVo vo : list) {
				JSONObject json_com = new JSONObject();
				json_com.put("comments_num", vo.getComments_num());
				json_com.put("userband_num", vo.getUserband_num());
				json_com.put("board_num", vo.getBoard_num());
				json_com.put("comments_content", vo.getComments_content());
				json_com.put("ref", vo.getRef());
				json_com.put("step", vo.getStep());
				String date=fm.format(vo.getComments_date()); 
				json_com.put("comments_date",date);
				json_com.put("comments_state", vo.getComments_state());
				json_com.put("band_nickname", vo.getBand_nickname());
				jarr.put(json_com);
			
			}
			json.put("comments", jarr);
		}
		json.put("comments_cnt", comments_cnt);
		json.put("maxpage", maxPage);
		
		
		System.out.println("Asdqw");
		resp.setContentType("test/palin;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json);
	}
}
