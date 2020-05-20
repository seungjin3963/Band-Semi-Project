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

import jhth.band.dao.ssjDao.CategoryDao;
import jhth.band.vo.ssjVo.ScategoryVo;
@WebServlet("/scategory.do")
public class MakeBand_scategory extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bcategorynum=Integer.parseInt(req.getParameter("bcategorynum"));
		
		CategoryDao dao=new CategoryDao();
		
		ArrayList<ScategoryVo> stitle = dao.scategory(bcategorynum);
		
		JSONArray scategory=new JSONArray();
		
		for (ScategoryVo vo : stitle) {
			JSONObject json=new JSONObject();
			json.put("scategorynum", vo.getScategoryNum());
			json.put("bcategorynum", vo.getBcategoryNum());
			json.put("category_stitle", vo.getCategory_stitle());
			scategory.put(json);
		}
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(scategory);
	}
}
