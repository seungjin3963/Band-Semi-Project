package jhta.band.controller.album;

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

@WebServlet("/board/imgview.do")
public class ImgMoreController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int imgPage = Integer.parseInt(req.getParameter("imgPage"));
		long band_num = Long.parseLong(req.getParameter("band_num"));
		
		ImgBoardDao dao = new ImgBoardDao();
		int startNum = 1;
		int endNum = 6;
		if(imgPage != 0) {
			int maxImg = dao.getImgCount(band_num);
			int maxPage = (int) Math.ceil(maxImg/12.0);
			startNum = (imgPage - 1)*12 + 1;
			endNum = startNum + 11;
			
			if(endNum> maxImg) {
				endNum=maxImg;
			}
		}
		
		ArrayList<ImgBoardVo> list =  dao.select(band_num, startNum, endNum);
		if(list != null) {
		JSONArray jarr_img= new JSONArray();
			for(ImgBoardVo vo:list) {
				JSONObject json_img = new JSONObject();
				json_img.put("img_url", vo.getImg_url());
				jarr_img.put(json_img);
			}
			resp.setContentType("test/palin;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(jarr_img);
		}
		
	}
}
