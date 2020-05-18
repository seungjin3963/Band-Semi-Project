package jhta.band.controller.login;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.loginDao;
@WebServlet("/findPwd.do")
public class findPwdController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//login_id,user_name,birth,user_quiz,answer
		String login_id = req.getParameter("login_id");
		String answer = req.getParameter("answer");
		
		loginDao dao = new loginDao();
		String pwd = dao.findPwd(login_id, answer);
		
		String code = "비밀번호: "+pwd;
		if(pwd == null || pwd == "") {
			code="fail";
		}
		req.setAttribute("code1", code);
		req.getRequestDispatcher("/login/findUser.jsp").forward(req,resp);
		
	}
}
