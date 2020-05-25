package jhta.band.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.loginDao;
@WebServlet("/findId.do")
public class findIdController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		String name = (String)req.getParameter("name");
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int date = Integer.parseInt(req.getParameter("date"));
		String phone = req.getParameter("user_phone");
		
		String birth1 = year+"-"+month+"-"+date;
		Date birth = Date.valueOf(birth1);
		
		loginDao dao = new loginDao();
		String id = dao.findId(name, birth, phone);
		
		String code = "¾ÆÀÌµð: "+id;
		if(id == null || id =="") {
			code="fail";
		}
		
		resp.setContentType("text/xml;charset=utf-8");
		
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
			pw.println("<code>"+code+"</code>");
		pw.print("</result>");
	}
}
