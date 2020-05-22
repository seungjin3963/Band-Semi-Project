package jhta.band.controller.memberslist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/membersrkdlq.do")
public class MembersrkdlqController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		int bnadnum=(int)session.getAttribute("b_n");
		long login_num=(long)session.getAttribute("login_num");
		String dudname=(String)session.getAttribute("dudname");
		
		System.out.println(login_num);
		
		//System.out.println(bnadnum);
	//	System.out.println(dudname);
		//System.out.println("로그인 번호 :" +login_num);
		
		memberslistDao dao=new memberslistDao();
		int n=dao.dudmembersinsert(bnadnum , login_num ,dudname);
		
		int a=dao.bandListinfo1(bnadnum, login_num);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<result>");
		if(n==1 && a==1) {	
			pw.println("<values>가입 신청 되었습니다.</values>");
		}else {
			pw.println("<values>가입 신청에 실패했습니다.</values>");
		}
			pw.println("</result>");
		}
	}

