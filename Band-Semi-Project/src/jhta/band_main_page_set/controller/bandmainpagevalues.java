package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band_main_page.controller.band_main_page_infoDao;
@WebServlet("/bandpagevalues.do")
public class bandmainpagevalues extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession paramBANDinfo = req.getSession();
		band_main_page_infoDao dao=new band_main_page_infoDao();
		int bandnum=(int)paramBANDinfo.getAttribute("b_n");		
		String date=dao.banddate(bandnum);
		int n=dao.countboard(bandnum);	
		paramBANDinfo.setAttribute("countboard", n);
		paramBANDinfo.setAttribute("band_Date", date);
		
		HttpSession sese=req.getSession();
		int  kkk=(int)sese.getAttribute("band_approved");
		
		if(kkk==1 || kkk==2) { 
			req.setAttribute("file", "band_main_page_m1/band_page_data12.jsp");
			req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
		}else { 
			req.setAttribute("file", "band_main_page_m1/band_page_data0.jsp");
			req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);	
		}
	}
}
