package jhta.band.controller.MakeBand_profile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhth.band.dao.MakeBandDao.ProfileDao;
@WebServlet("/profileout.do")
public class ProfileOutputController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpeg");
		ProfileDao dao=new ProfileDao();
		
		long loginnum=(long) req.getSession().getAttribute("login_num");
		
		ByteArrayInputStream data=new ByteArrayInputStream(dao.imgOutput(loginnum));
		
		ServletOutputStream os=resp.getOutputStream();
		
		int dataReader=0;
		
		while((dataReader=data.read()) != -1) {
			os.write(dataReader);
		}
	}
}
