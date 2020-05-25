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
@WebServlet("/commentdelete.do")
public class CommentsDelete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		Long board_num = Long.parseLong(req.getParameter("board_num"));
				
		Long comments_num = Long.parseLong(req.getParameter("comments_num"));
		
		CommentsDao dao = new CommentsDao();
		int n = dao.delete(comments_num);
		
		JSONObject json_origin = new JSONObject();
		
		if(n>0) {
			json_origin.put("result", "success");
		}else{
			json_origin.put("result", "fail");
		}
		resp.setContentType("test/palin;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json_origin);
	}
}
