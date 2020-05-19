package jhta.band.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.loginDao;
@WebServlet("/loginOk.do")
public class loginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String loginId = req.getParameter("loginId");
		String loginPwd = req.getParameter("loginPwd");
		
		loginDao dao = new loginDao();
		long a = dao.select(loginId, loginPwd);
		String code = "sucess";
		if(a <= 0) {
			code = "false";
		}
		HttpSession session = req.getSession();
		session.setAttribute("login_num", a);
		
		req.setAttribute("loginId", loginId);
		req.setAttribute("loginPwd", loginPwd);
		req.setAttribute("code",code);
		req.getRequestDispatcher("/login/loginOk.jsp").forward(req,resp);
		
	}
}
