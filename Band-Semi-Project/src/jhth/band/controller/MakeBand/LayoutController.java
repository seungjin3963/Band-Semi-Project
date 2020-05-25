package jhth.band.controller.MakeBand;

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
import jhth.band.dao.MakeBandDao.BandListDao;
import jhth.band.vo.MakeBandVo.BandListVo;
@WebServlet("/layout.do")
public class LayoutController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String file=req.getParameter("file");
		
		BandListDao listdao=new BandListDao();
		long a=(long) req.getSession().getAttribute("login_num");
		ArrayList<BandListVo>bandlist=listdao.band_list(a);
		
		req.setAttribute("bandlist", bandlist);
		
		req.setAttribute("footer","/serch/random_band.jsp");

		bandDao dao1=new bandDao();
		ArrayList<bandSerchVo> random_list=dao1.random();
		req.setAttribute("random_list",random_list);
		
		if(file == null) {
			req.setAttribute("file", "/BandList/bandList.jsp");
		}else {
			req.setAttribute("file", file);
		}
		req.getRequestDispatcher("/MakingBand/bandList_layout.jsp").forward(req, resp);
	}
}
