package jhta.band.controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jhta.band.dao.board.CommentsDao;
import jhta.band.vo.board.CommentsVo;

@WebServlet("/commentsUpload.do")
public class CommentsUploadController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		
		long band_num = Long.parseLong(req.getParameter("band_num"));
		long userband_num = Long.parseLong(req.getParameter("userband_num"));
		long board_num = Long.parseLong(req.getParameter("board_num"));
		String comments_text= req.getParameter("comments_text");
		
		CommentsVo vo = new CommentsVo(0, userband_num, board_num, comments_text, 0, 0, null,0);
		
		CommentsDao dao = new CommentsDao();
		
		int n = dao.insert(vo);
		
		JSONObject json = new  JSONObject();
		if(n>0) {
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}	
		resp.setContentType("test/palin;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json);
	}
}
