package jhth.band.controller.MakeBand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import jhth.band.dao.ssjDao.BandCoverDao;
import jhth.band.vo.ssjVo.CoverVo;
@WebServlet("/bandcover.do")
public class MakeBand_bandcover extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int coverpage=Integer.parseInt(req.getParameter("coverpage"));
		BandCoverDao dao=new BandCoverDao();
		ArrayList<CoverVo> cover=dao.cover(coverpage);
		
		JSONArray jarr=new JSONArray();
		
		for(CoverVo vo: cover) {
			JSONObject json=new JSONObject();
			json.put("url", vo.getCoverURL());
			jarr.put(json);
		}
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(jarr);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String scategory = req.getParameter("scategory");
		
		int num = 1;
		
		BandCoverDao dao=new BandCoverDao();
		
		ArrayList<CoverVo> cover=dao.cover(num);
		req.setAttribute("scategory", scategory);
		req.setAttribute("file", "MakingBand/makeband.jsp");
		req.setAttribute("cover", cover);
		req.getRequestDispatcher("/bandList_layout.jsp").forward(req, resp);
	}
}