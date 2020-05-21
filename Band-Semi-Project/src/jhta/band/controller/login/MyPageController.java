package jhta.band.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;

@WebServlet("/MyPage.do")
public class MyPageController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		long login_num = (long)session.getAttribute("login_num");
		
		loginDao dao = new loginDao();
		JoinVo vo = dao.selectInfo(login_num);
		
		req.setAttribute("joinVo", vo);
		req.getRequestDispatcher("/login/MyInfo.jsp").forward(req,resp);
	}
}
