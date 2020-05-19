package jhta.band.controller.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.loginDao;
import jhth.band.dao.ssjDao.BandListDao;
import jhth.band.vo.ssjVo.BandListVo;
@WebServlet("/loginOk.do")
public class loginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String loginId = req.getParameter("loginId");
		String loginPwd = req.getParameter("loginPwd");
		
		loginDao dao = new loginDao();
		long a = dao.select(loginId, loginPwd);
		if(a <= 0) {
			resp.sendRedirect(req.getContextPath()+"/login/login.jsp");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("login_num", a);
			
			BandListDao listdao=new BandListDao();
			
			ArrayList<BandListVo>bandlist=listdao.band_list(a);
			
			String file=req.getParameter("file");
			
			req.getSession().setAttribute("header", "bandList_header.jsp");
			req.setAttribute("bandlist", bandlist);
			
			if(file == null) {
				req.setAttribute("file", "/BandList/bandList.jsp");
			}else {
				req.setAttribute("file", file);
			}
			req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
		}
	}
}
