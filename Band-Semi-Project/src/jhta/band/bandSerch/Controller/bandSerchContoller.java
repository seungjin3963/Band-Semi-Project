package jhta.band.bandSerch.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.bandSerch.Dao.bandDao;
import jhta.band.bandSerch.Vo.bandSerchVo;
import jhta.band.bandSerch.Vo.bandVo;
@WebServlet("/bandSerch")
public class bandSerchContoller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String keyword=req.getParameter("keyword");
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {pageNum=Integer.parseInt(spageNum);}
		int startRow=(pageNum-1)*3+1;
		int endRow=startRow+2;
		bandDao dao=new bandDao();
		ArrayList<bandSerchVo> list=dao.serch1(startRow,endRow,keyword);
		int getcount=dao.getCount(keyword);
		int pageCount=(int)Math.ceil(dao.getCount(keyword)/3.0);	
		int startPage=(pageNum-1)/3*3+1;
		int endPage=startPage+2;
		if(endPage>pageCount) {endPage=pageCount;}
		req.setAttribute("list",list);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("startPage",startPage);
		req.setAttribute("endPage",endPage);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("getcount",getcount);
		System.out.println(keyword);
		
		//req.setAttribute("list", list);
		req.setAttribute("keyword",keyword);
		req.setAttribute("file", "/serch/test1.jsp");
		req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req, resp);
		
	}
}
