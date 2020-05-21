package jhta.band.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.dao.board.BoardDao;
import jhta.band.vo.board.BoardVo;

@WebServlet("/board/totContent.do")
public class totContentController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int band_num = 1;
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		list = dao.select(band_num);
		
		req.setAttribute("list", list);
		req.setAttribute("band_num", 1);
		req.setAttribute("userband_num", 1);
		
		req.setAttribute("file","/band_board.jsp");
		
		req.getRequestDispatcher("/band_main/band_main.jsp").forward(req, resp);
	}
}




