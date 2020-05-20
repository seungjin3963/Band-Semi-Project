package jhta.band.controller.update_userInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.dao.loginDao;
import test.vo.JoinVo;

@WebServlet("/Cancle.do")
public class CancleController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		long login_num = (long)session.getAttribute("login_num");
		
		loginDao dao = new loginDao();
		JoinVo vo = dao.selectInfo(login_num);
		
		req.setAttribute("joinVo", vo);
		req.getRequestDispatcher("MyInfo.jsp").forward(req,resp);
	}
}
