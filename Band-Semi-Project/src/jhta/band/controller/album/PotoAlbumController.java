package jhta.band.controller.album;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.dao.board.ImgBoardDao;
import jhta.band.vo.board.ImgBoardVo;

@WebServlet("/board/potoalbum.do")
public class PotoAlbumController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//long band_num = Long.parseLong(req.getParameter("band_num"));
		long band_num =1;
		ImgBoardDao dao = new ImgBoardDao();
		
		int imgCnt = dao.getImgCount(band_num);
		int maxPage = (int) Math.ceil(imgCnt/12.0);
		
		req.setAttribute("band_num", band_num);
		req.setAttribute("imgCnt", imgCnt);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("file","/band_album.jsp");
		resp.setCharacterEncoding("utf-8");
		
		req.getRequestDispatcher("/band_main/band_main.jsp").forward(req, resp);
		
		
	}
}
