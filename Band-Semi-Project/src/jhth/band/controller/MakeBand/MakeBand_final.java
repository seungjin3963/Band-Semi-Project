package jhth.band.controller.MakeBand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.bandSerch.Dao.bandDao;
import jhta.band.bandSerch.Vo.bandVo;
import jhta.band.dao.loginDao;
import jhta.band.vo.JoinVo;
import jhth.band.dao.MakeBandDao.BandListDao;
import jhth.band.dao.MakeBandDao.MakebandDao;
import jhth.band.vo.MakeBandVo.BandListVo;
import jhth.band.vo.MakeBandVo.MakebandVo;
@WebServlet("/makeband_end.do")
public class MakeBand_final extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bandname=req.getParameter("bandname");
		String bandintroduct=req.getParameter("bandintroduct");
		int bandcoverimg=Integer.parseInt(req.getParameter("bandcover"));
		int open=Integer.parseInt(req.getParameter("open"));
		int scategory=Integer.parseInt(req.getParameter("scategory"));
		
		long loginnum=Long.parseLong(req.getParameter("loginnum"));
		
		loginDao userinfo=new loginDao();
		JoinVo userinfovo = userinfo.selectInfo(loginnum);
		MakebandVo data=new MakebandVo(0,scategory,bandname,open,bandintroduct,bandcoverimg,null,0);
		
		MakebandDao dao=new MakebandDao();
		
		int n=dao.makeband(data,loginnum,userinfovo.getUser_name());
		
		if(n>0) {
			BandListDao listdao=new BandListDao();
			ArrayList<BandListVo>bandlist=listdao.band_list(loginnum);
			req.setAttribute("bandlist", bandlist);
			
			req.setAttribute("footer","/serch/random_band.jsp");

			bandDao dao1=new bandDao();
			ArrayList<bandVo> random_list=dao1.random();
			req.setAttribute("random_list",random_list);
			
			req.setAttribute("file", "/BandList/bandList.jsp");
			req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req,resp);
		}else {
			System.out.println("½ÇÆÐ");
		}
	}	
}
