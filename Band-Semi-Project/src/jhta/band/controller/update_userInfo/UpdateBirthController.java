package jhta.band.controller.update_userInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.dao.UpdateInfoDao;
import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;

@WebServlet("/Birth.do")
public class UpdateBirthController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int year = Integer.parseInt(req.getParameter("year_select"));
		int month = Integer.parseInt(req.getParameter("month_select"));
		int date = Integer.parseInt(req.getParameter("date_select"));
		
		HttpSession session = req.getSession();
		long login_num = (long)session.getAttribute("login_num");
		
		String birth = year+"-"+month+"-"+date;
		Date user_birth = Date.valueOf(birth);
		
		UpdateInfoDao dao = new UpdateInfoDao();
		Date update_birth = dao.updateBirth(user_birth, login_num); // 바뀐 날짜 넣고 얻어오기
		
		loginDao dao1 = new loginDao();
		JoinVo vo = dao1.selectInfo(login_num);		// JoinVo얻어옴
		
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
