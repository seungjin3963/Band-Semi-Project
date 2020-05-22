package jhta.band.controller.update_userInfo;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;

@WebServlet("/CancleBirth.do")
public class CancleBirthController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
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
		
		SimpleDateFormat year1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat month1 = new SimpleDateFormat("MM");
		SimpleDateFormat date1 = new SimpleDateFormat("dd");
		Date birth = vo.getUser_birth();
		
		String year = year1.format(birth);
		String month = month1.format(birth);
		String date = date1.format(birth);
		
		req.setAttribute("year", year);
		req.setAttribute("month", month);
		req.setAttribute("date", date);
		
		req.setAttribute("joinVo", vo);
		
		session.setAttribute("header", "bandList_header.jsp");
		req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
	}
}
