package jhta.band.controller.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jhta.band.bandSerch.Dao.bandDao;
import jhta.band.bandSerch.Vo.bandSerchVo;
import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;
import jhth.band.dao.MakeBandDao.BandListDao;
import jhth.band.vo.MakeBandVo.BandListVo;
@WebServlet("/go_main.do")
public class GoMainController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		long login_num = (long)session.getAttribute("login_num");
		
		if(login_num < 0) {
			
		}else {			
			BandListDao listdao=new BandListDao();
			
			ArrayList<BandListVo>bandlist=listdao.band_list(login_num);

			String file=req.getParameter("file");
			
			req.getSession().setAttribute("header", "bandList_header.jsp");
			req.setAttribute("bandlist", bandlist);
			
			if(file == null) {
				req.setAttribute("file", "/BandList/bandList.jsp");
			}else {
				req.setAttribute("file", file);
			}
			
			req.setAttribute("footer","/serch/random_band.jsp");
			  bandDao dao1=new bandDao();
			  ArrayList<bandSerchVo> random_list=dao1.random();
			  req.setAttribute("random_list",random_list);
			
			req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
			
		}
	}
}
