package jhta.band.controller.calender;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calender_insert")
public class InsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int calender_num=6;//시컨스
		
		HttpSession session=req.getSession();//밴드 번호
		int band_n=(int) session.getAttribute("b_n");
	
		String calender_title=req.getParameter("calender_title");
		String calender_content=req.getParameter("calender_content");
		String calender_date=req.getParameter("calender_date");
		CalenderDvo vo=new CalenderDvo(calender_num,band_n,calender_title,calender_date,calender_content);
		CalenderDao dao=new CalenderDao();
		dao.CalenderInsert(vo);
		
		String cp=req.getContextPath();
		req.setAttribute("cp", cp);
		req.setAttribute("file", "band_main_page_m2/Calender/calender.jsp");
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
		
	}
}











