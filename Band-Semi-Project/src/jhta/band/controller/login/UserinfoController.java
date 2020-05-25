package jhta.band.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.dao.loginDao;
import jhta.band.vo.UserinfoVo;
import jhta.band.vo.loginVo;
@WebServlet("/Users.do")
public class UserinfoController extends HttpServlet{
	// 회占쏙옙占쏙옙占쏙옙
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String login_id = req.getParameter("login_id");
		String login_pwd = req.getParameter("login_pwd");
		String user_name = req.getParameter("user_name");
		String phone = req.getParameter("user_phone");
		
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int date = Integer.parseInt(req.getParameter("date"));
		
		String birth1 = year+"-"+month+"-"+date;
		Date birth = Date.valueOf(birth1);
		
		String user_gender = req.getParameter("user_gender");
		String user_quiz = req.getParameter("user_quiz");	// 占쏙옙占쏙옙占쏙옙占쏙옙獵占� 占쏙옙占쏙옙
		String user_quiz1 = req.getParameter("user_quiz1");	// 占쏙옙占쏙옙 占쌉뤄옙占싹댐옙 占쏙옙占쏙옙
		String quiz_direct = req.getParameter("quiz_direct");// 占쏙옙占쏙옙 占쌉뤄옙 占쏙옙 占쏙옙占쏙옙 radio占쏙옙 체크
		
		if(quiz_direct.equals("true")) {
			user_quiz = user_quiz1;
		}
		
		String user_answer = req.getParameter("user_answer");
		
		UserinfoVo uservo = new UserinfoVo(1,user_name,phone,null,user_gender,
											user_quiz,user_answer,null,birth);
		loginVo loginvo = new loginVo(1,login_id,login_pwd,null,1);
		
		loginDao dao = new loginDao();
		int n = dao.insert(loginvo, uservo);
		String code = "success";
		if(n <= 0) {
			code="fail";
		}
		
		//System.out.println();
		
		// 占쏙옙占쏙옙占쌔억옙 占쏙옙 占쏙옙치
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.println("<code>"+code+"</code>");
		pw.print("</result>");
	}
}
