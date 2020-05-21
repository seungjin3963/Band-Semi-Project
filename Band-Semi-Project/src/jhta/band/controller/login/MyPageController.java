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
		
		String file = req.getParameter("file");
		
		if(file == null) {
			req.setAttribute("file", "/login/MyInfo.jsp");
		}else {
			req.setAttribute("file", file);
		}
		
		session.setAttribute("header", "bandList_header.jsp");
		req.setAttribute("joinVo", vo);
		req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
	}
}
