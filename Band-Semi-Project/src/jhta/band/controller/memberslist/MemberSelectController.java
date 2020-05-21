package jhta.band.controller.memberslist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/member_select.do")
public class MemberSelectController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		//¹êµå ¹øÈ£
		int band_n=(int) session.getAttribute("b_n");
		System.out.println("aaaaaaaaaaaaaaaaaa");
		memberslistDao dao=new memberslistDao();
		ArrayList<mainpagemembersDvo> list=dao.bandmembersSelect(band_n);
		System.out.println("aaaaaaaaaaaaaaaaaa");
		req.setAttribute("list",list);
		String cp=req.getContextPath();
		req.setAttribute("cp", cp);
		req.setAttribute("file", "band_main_page_m2/band_main_members/band_main_members.jsp");
		req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
		
	}
}
