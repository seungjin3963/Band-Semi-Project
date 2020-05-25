package jhta.band.controller.modal;

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

import jhta.band.dao.board.ImgBoardDao;
import jhta.band.vo.board.ImgBoardVo;

@WebServlet("/imgModal.do")
public class ImgModalUploadController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long board_num = Long.parseLong(req.getParameter("board_num"));
		ImgBoardDao dao = new ImgBoardDao();
		
		ArrayList<ImgBoardVo> list = dao.select(board_num);
		
		JSONArray jarr = new JSONArray();
		
		for(ImgBoardVo vo:list) {
			JSONObject json = new JSONObject();
			
			json.put("url", vo.getImg_url());
			jarr.put(json);
		}
		resp.setContentType("test/palin;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(jarr);
		
	}
}
 