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
@WebServlet("/approvalno.do")
public class MembersapprovalnoController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");//닉네임
		int user_num=Integer.parseInt(req.getParameter("num"));//유저 번호
		
		HttpSession session=req.getSession();//밴드 번호
		int band_n=(int) session.getAttribute("b_n");

		
		memberslistDao dao=new memberslistDao();
		int n=dao.updateapproved2(name,user_num,band_n);
		
		ArrayList<mainpagemembersDvo> list=dao.memberscheck(band_n);
		req.setAttribute("list",list);
	
			
			if(n==1) {
				req.setAttribute("file", "/band_main_page/band_main_page_m2/band_main_members/band_member_joincheck.jsp");
				req.getRequestDispatcher("/band_main_page/band_main_page.jsp").forward(req, resp);
			}else {
		
			}	
		}
}
