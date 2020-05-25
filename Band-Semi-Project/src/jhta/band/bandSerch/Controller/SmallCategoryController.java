package jhta.band.bandSerch.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.bandSerch.Dao.bandDao;
import jhta.band.bandSerch.Vo.bandSerchVo;
import jhta.band.bandSerch.Vo.bandVo;
@WebServlet("/smallCategory")
public class SmallCategoryController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String category_stitle=req.getParameter("category_stitle");
		bandDao dao=new bandDao();
		//ArrayList<bandVo> list=dao.categoryContents("category_stitle");
		ArrayList<bandSerchVo> list=dao.random();
		req.setAttribute("list",list);
		req.setAttribute("category_stitle", category_stitle);
		req.setAttribute("footer","/serch/scategory.jsp");
		
		req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req, resp);
		//req.getRequestDispatcher("scategory1.jsp").forward(req, resp);
	}
}
