package jhta.band.bandSerch.Controller;

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

import jhta.band.bandSerch.Dao.bandDao;
import jhta.band.bandSerch.Vo.bandSerchVo;
import jhta.band.bandSerch.Vo.bandVo;
@WebServlet("/sView")
public class sViewController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//String category_stitle=req.getParameter("category_stitle");
		String snum=req.getParameter("snum");
		int num=0;
		if(snum!=null||snum=="") {
			num=Integer.parseInt(snum);
		}
		bandDao dao=new bandDao();
		//ArrayList<bandVo> list=dao.categoryContents("category_stitle");
		ArrayList<bandSerchVo> list=dao.bandMoreSerch(num);
	//	req.setAttribute("list",list);
	//	req.setAttribute("category_stitle", category_stitle);
	//	req.setAttribute("footer","/scategory.jsp");
	//	String snum=req.getParameter("snum");
	//	if(snum!=null) {
	//		req.setAttribute("snum", snum);
	//	}
		JSONArray jarr=new JSONArray();
		for(bandSerchVo vo: list) { 
			JSONObject json=new JSONObject();
			json.put("bandimg", vo.getBandimg());
			json.put("band_num", vo.getBand_num());
			json.put("band_name", vo.getBand_name());
			json.put("band_intoroductio", vo.getBand_intoroductio());
			json.put("bandLeader", vo.getBandLeader());
			json.put("bandcnt", vo.getBandcnt());
			jarr.put(json);
		}
		resp.setContentType("text/plain;charset=utf-8");
	    PrintWriter pw=resp.getWriter();
		pw.print(jarr);
	}
}
