package jhta.band.controller.MakeBand_profile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.dao.band_userinfo.BandUserInfoDao;
import jhth.band.dao.MakeBandDao.ProfileDao;
@WebServlet("/userprofile.do")
public class UserProfileOutputController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long userprofile=Long.parseLong(req.getParameter("userprofile"));
		
		BandUserInfoDao change=new BandUserInfoDao();
		ProfileDao dao=new ProfileDao();
		
		Long loginnum = change.selectloginnum(userprofile);
		
		ByteArrayInputStream data=new ByteArrayInputStream(dao.imgOutput(loginnum));
		
		ServletOutputStream os=resp.getOutputStream();
		
		int dataReader=0;
		
		while((dataReader=data.read()) != -1) {
			os.write(dataReader);
		}	
	}
}
