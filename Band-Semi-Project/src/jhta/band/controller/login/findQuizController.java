package jhta.band.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jhta.band.dao.loginDao;
@WebServlet("/findQuiz.do")
public class findQuizController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = (String)req.getParameter("id");
		String name = (String)req.getParameter("name");
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int date = Integer.parseInt(req.getParameter("date"));
		
		String birth1 = year+"-"+month+"-"+date;
		Date birth = Date.valueOf(birth1);
		
		loginDao dao = new loginDao();
		String quiz = dao.findQuiz(id, name, birth);
		
		JSONObject json=new JSONObject();
		json.put("login_id", id);
		json.put("user_name", name);
		json.put("birth", birth);
		json.put("user_quiz", quiz);
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(json);
	}
}
