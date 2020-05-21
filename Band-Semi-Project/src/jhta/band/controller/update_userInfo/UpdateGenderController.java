package jhta.band.controller.update_userInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.UpdateInfoDao;
import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;

@WebServlet("/Gender.do")
public class UpdateGenderController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String radio_value = req.getParameter("radio_gender");
		
		HttpSession session = req.getSession();
		long login_num = (long)session.getAttribute("login_num");
		
		UpdateInfoDao dao = new UpdateInfoDao();
		String update_gender = dao.updateGender(radio_value, login_num);
		
		loginDao dao1 = new loginDao();
		JoinVo vo = dao1.selectInfo(login_num);
		
		String file = req.getParameter("file");
		
		if(file == null) {
			req.setAttribute("file", "/login/MyInfo.jsp");
		}else {
			req.setAttribute("file",file);
		}
		session.setAttribute("header", "bandList_header.jsp");
		req.setAttribute("joinVo", vo);
		req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
	}
}
