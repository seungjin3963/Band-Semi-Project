package jhth.band.controller.MakeBand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhth.band.dao.ssjDao.MakebandDao;
import jhth.band.vo.ssjVo.MakebandVo;
@WebServlet("/band/makeband_end.do")
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
		
		System.out.println(loginnum);
		
		MakebandVo data=new MakebandVo(0,scategory,bandname,open,bandintroduct,bandcoverimg,null,0);
		
		MakebandDao dao=new MakebandDao();
		int n=dao.makeband(data,loginnum);
//		
//		if(n>0) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
	}	
}
