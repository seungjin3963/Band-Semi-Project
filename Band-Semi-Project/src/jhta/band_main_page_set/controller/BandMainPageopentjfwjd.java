package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/rhdrotjfwjd.do")
public class BandMainPageopentjfwjd extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int valeus=Integer.parseInt(req.getParameter("values"));
		
		HttpSession paramBANDinfo = req.getSession();
		int bandnum=(int)paramBANDinfo.getAttribute("b_n");
		bandmainpagesetdao dao=new bandmainpagesetdao();
		int n=dao.mainpagesetting(bandnum , valeus);
		
		req.setAttribute("file", "/band_board/band_board.jsp");
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
}
}
