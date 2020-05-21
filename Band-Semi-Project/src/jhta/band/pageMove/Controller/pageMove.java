package jhta.band.pageMove.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pageMove extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String aa1=req.getParameter("");
		String aa2=req.getParameter("");
		String aa3=req.getParameter("");
		req.getRequestDispatcher("").forward(req, resp);
	}
}
