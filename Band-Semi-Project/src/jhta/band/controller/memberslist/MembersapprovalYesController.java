package jhta.band.controller.memberslist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/approvalyes.do")
public class MembersapprovalYesController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");//닉네임
		int user_num=Integer.parseInt(req.getParameter("num"));//유저 번호
		
		HttpSession session=req.getSession();//밴드 번호
		int band_n=(int) session.getAttribute("b_n");
		System.out.println(name);
		System.out.println("u   "+user_num);
		System.out.println(band_n);

		
		memberslistDao dao=new memberslistDao();
		int n=dao.updateapproved1(name,user_num,band_n);
		System.out.println("aaa  " +n);
		
		if(n==1) {
			 resp.setContentType("text/xml;charset=utf-8");
			 PrintWriter pw=resp.getWriter();
			 pw.print("<?xml version='1.0' encoding='utf-8' ?>");
			 pw.print("<result>");	
				 pw.print("<update>가입 승인 되었습니다</update>");				
			 pw.print("</result>");
		}else {
			resp.setContentType("text/xml;charset=utf-8");
			 PrintWriter pw=resp.getWriter();
			 pw.print("<?xml version='1.0' encoding='utf-8' ?>");
			 pw.print("<result>");
				 pw.print("<update>가입 승인이 실패하였습니다</update>");
			 pw.print("</result>");
		}
	}
}
