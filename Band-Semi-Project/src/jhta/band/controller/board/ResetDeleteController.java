package jhta.band.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jhta.band.dao.board.TempImgeDao;

@WebServlet("/resetDelete.do")
public class ResetDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String text = req.getParameter("text");
		Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
	    Matcher matcher = pattern.matcher(text);
	    
	    
	    
	    while(matcher.find()){
	    	String url = req.getServletContext().getRealPath("/upload") + "\\" + matcher.group(1).substring(7);
	    	File file = new File(url);
	    	file.delete();
        }
	    
	    
	    int userband_num = Integer.parseInt(req.getParameter("userband_num"));
	    TempImgeDao dao = new TempImgeDao();
	    
	    dao.delete(userband_num);
	    
	    

	}
}
