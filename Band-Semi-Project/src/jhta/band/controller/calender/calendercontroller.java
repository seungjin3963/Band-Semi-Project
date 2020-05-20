package jhta.band.controller.calender;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calender.con")
public class calendercontroller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cp=req.getContextPath();
		req.setAttribute("cp", cp);
		req.setAttribute("file","band_main_page_m2/Calender/calender.jsp" );
		
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
	}
}
