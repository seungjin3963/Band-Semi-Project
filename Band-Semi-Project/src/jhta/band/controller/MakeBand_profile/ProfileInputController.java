package jhta.band.controller.MakeBand_profile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;
import jhth.band.dao.MakeBandDao.ProfileDao;
@WebServlet("/profilein.do")
public class ProfileInputController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long loginnum=(long) req.getSession().getAttribute("login_num");
		ServletContext application=req.getServletContext();
		
		String upload=application.getRealPath("/upload");
		
		MultipartRequest mr=new MultipartRequest(
				req, 
				upload, 
				1025*1024*5, 
				"utf-8",
				new DefaultFileRenamePolicy()
				); 
			
			String file=mr.getFilesystemName("potofile");
			String location=upload+"/"+file;
			
			ProfileDao dao=new ProfileDao();
			int n=dao.imgInput(location, loginnum);
			
			File tempfile=new File(location);
			
			tempfile.delete();
			
			loginDao logindao = new loginDao();
			JoinVo vo = logindao.selectInfo(loginnum);
				
			req.setAttribute("file", "/login/MyInfo.jsp");
				
				
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
			req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
			
		}
}

