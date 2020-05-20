package jhta.band.controller.memberslist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/members_like_select")
public class MembersLikeSelectController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss=req.getSession();
		int sss=(int)ss.getAttribute("b_n");//¹êµå ¹øÈ£
		
		String selecttext=req.getParameter("selecttext");
		String selectoption=req.getParameter("selectoption");
		
		memberslistDao dao=new memberslistDao();
		
		ArrayList<String> list=new ArrayList<String>();
		if(selectoption.equals("1")) {
			
			list=dao.likeselect(selecttext , sss);
			System.out.println(list);
		}else {
			list=dao.regdateselect(selecttext , sss);
			System.out.println(list);
		}
		req.setAttribute("list",list);
		String cp=req.getContextPath();
		req.setAttribute("cp", cp);
		req.setAttribute("file", "band_main_page_m2/band_main_members/band_main_members.jsp");
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
	}
}
