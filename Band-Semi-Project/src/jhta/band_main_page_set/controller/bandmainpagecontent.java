package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/updatecontent.do")
public class bandmainpagecontent extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value=req.getParameter("dudsh");
		//System.out.println(value);
		HttpSession paramBANDinfo = req.getSession();
		int bandnum=(int)paramBANDinfo.getAttribute("b_n");
		
		bandmainpagesetdao dao=new bandmainpagesetdao();
		int n=dao.updatecon(bandnum , value);
		String content=dao.sessioncon(bandnum);
		
		paramBANDinfo.setAttribute("band_intoroductio", content);
		req.setAttribute("file", "/band_main_page/band_main_page_m1/band_page_admin.jsp");
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
		
	}
}
