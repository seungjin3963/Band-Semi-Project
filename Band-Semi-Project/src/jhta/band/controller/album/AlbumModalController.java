package jhta.band.controller.album;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jhta.band.dao.board.ImgBoardDao;
import jhta.band.vo.board.ImgBoardVo;

@WebServlet("/albumModal.do")
public class AlbumModalController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long img_num = Long.parseLong(req.getParameter("img_num"));
		long band_num = Long.parseLong(req.getParameter("band_num"));
		
		
		
		ImgBoardDao dao = new ImgBoardDao();
		
		ImgBoardVo vo = dao.selectModal(img_num, band_num);
		
		JSONObject json = new JSONObject();
		
		json.put("img_url", vo.getImg_url());
		json.put("prevNum", vo.getPrevNum());
		json.put("nextNum", vo.getNextNum());
		
		resp.setContentType("test/palin;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		
	}
}
