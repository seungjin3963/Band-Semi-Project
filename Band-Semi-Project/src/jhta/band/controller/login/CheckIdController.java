package jhta.band.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.dao.loginDao;

@WebServlet("/checkId.do")
public class CheckIdController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = (String)req.getParameter("inputId2");
		
		loginDao dao = new loginDao();
		String outputId = dao.check_id(id);
		
		if(outputId == null) {
			outputId ="success";
		}
		
		resp.setContentType("text/xml;charset=utf-8");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
			pw.println("<code>"+outputId+"</code>");
		pw.print("</result>");
	}
}
