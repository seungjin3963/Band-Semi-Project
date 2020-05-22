package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/bandout.do")
public class bandoutController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("È¸¿ø Å»Åð");
		HttpSession paramBANDinfo = req.getSession();
		int usernum=(int)paramBANDinfo.getAttribute("userband_num");
		//System.out.println("À¯Àú ³Ñ:"+usernum);
		int bandnum=(int)paramBANDinfo.getAttribute("b_n");
		//System.out.println("¹êµå ³Ñ:" +bandnum);
		bandmainpagesetdao dao=new bandmainpagesetdao();
		int n=dao.bandout(bandnum,usernum);
		
		if(n==1) {
			req.getRequestDispatcher("banddelete.jsp").forward(req, resp);
		}
	}
	

}
