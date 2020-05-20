package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bandmainpageopen.do")
public class BandMainPageOpenController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cp=req.getContextPath();
		req.setAttribute("cp", cp);
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp?file=band_main_page_m1/band_page_open.jsp").forward(req, resp);
	}
}
