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

import jhta.band.dao.UpdateInfoDao;
import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;

@WebServlet("/Phone.do")
public class UpdatePhoneController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String phoneNumber = req.getParameter("phoneNumber");
		
		HttpSession session = req.getSession();
		long login_num = (long)session.getAttribute("login_num");
		
		UpdateInfoDao dao = new UpdateInfoDao();
		String phone = dao.updatePhone(phoneNumber, login_num);
		
		loginDao dao1 = new loginDao();
		JoinVo vo = dao1.selectInfo(login_num);
		
		SimpleDateFormat year1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat month1 = new SimpleDateFormat("MM");
		SimpleDateFormat date1 = new SimpleDateFormat("dd");
		
		Date birth = vo.getUser_birth();
		
		String year_string = year1.format(birth);
		String month_string = month1.format(birth);
		String date_string = date1.format(birth);
		
		req.setAttribute("year", year_string);
		req.setAttribute("month", month_string);
		req.setAttribute("date", date_string);		
		req.setAttribute("joinVo", vo);
		
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
