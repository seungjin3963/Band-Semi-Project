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
import jhth.band.vo.ssjVo.BcategoryVo;
@WebServlet("/category.do")
public class MakeBand_bcategory extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String file=req.getParameter("file");
		CategoryDao dao=new CategoryDao();
		int num=1;
		ArrayList<BcategoryVo> category=dao.bcategory(num);
		
		for (int i = 0; i < category.size(); i++) {
			category.get(i).getBcategoryNum();
		}
		
		req.setAttribute("category", category);
		req.setAttribute("file", file);
		req.getRequestDispatcher("/bandList_layout.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		CategoryDao dao=new CategoryDao();
		int canum=Integer.parseInt(req.getParameter("category"));
		ArrayList<BcategoryVo> category=dao.bcategory(canum);
		
		JSONArray jarr=new JSONArray();
		
		for(BcategoryVo vo: category) {
			JSONObject json=new JSONObject();
			json.put("bnum", vo.getBcategoryNum());
			json.put("title", vo.getCategory_btitle() );
			json.put("curl", vo.getCategoryimg() );
			jarr.put(json);
		}
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(jarr);
	}
}
