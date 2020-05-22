package jhta.band_main_page_set.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/setBand_page.do")
public class BandMainPageSetController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		///////////밴드 설정 controller
		int a=2;
		HttpSession sese=req.getSession();
		int aaaaa=(int)sese.getAttribute("band_approved");
		
		String cp=req.getContextPath();
		req.setAttribute("cp", cp);
		
		if(aaaaa==1) { //관리자 이면
			
			req.setAttribute("file", "/band_main_page/band_main_page_m1/band_page_admin.jsp");
			req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
		}
		else{ //일반 회원이면
			
			req.setAttribute("file", "/band_main_page/band_main_page_m1/band_page_notadmin.jsp");
			req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);	
		}
	}
}
