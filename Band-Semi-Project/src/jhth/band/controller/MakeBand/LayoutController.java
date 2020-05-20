package jhth.band.controller.MakeBand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/band/layout.do")
public class LayoutController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String file=req.getParameter("file");
		
		if(file == null) {
			resp.sendRedirect(req.getContextPath()+"/bandList_layout.jsp");
		}else {
			req.setAttribute("file", file);
			req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req, resp);
		}
	}
}
