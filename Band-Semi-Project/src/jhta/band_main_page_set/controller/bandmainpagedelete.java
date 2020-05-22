package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/deleteband.do")
public class bandmainpagedelete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession paramBANDinfo = req.getSession();
		int bandnum=(int)paramBANDinfo.getAttribute("b_n");
		
		bandmainpagesetdao dao=new bandmainpagesetdao();
		int n=dao.deleteband(bandnum);
		
		if(n!=-1) {
			req.getRequestDispatcher("/banddelete.jsp").forward(req, resp);	
		}
	}
}
