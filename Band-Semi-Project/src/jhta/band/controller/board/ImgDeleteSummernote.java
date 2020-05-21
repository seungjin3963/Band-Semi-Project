package jhta.band.controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.oreilly.servlet.MultipartFilter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jhta.band.dao.board.TempImgeDao;
import jhta.band.vo.board.TmpImgVo;

@WebServlet("/summernoteDelete.do")
public class ImgDeleteSummernote extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet");
		resp.setContentType("text/html);charset=utf-8");
		
		String src = req.getParameter("src");
		System.out.println(src);
		int index = src.indexOf("upload");
		System.out.println(req.getServletContext().getRealPath("/upload") + src.substring(index + 6));
		File file = new File(req.getServletContext().getRealPath("/upload") + src.substring(index + 6));
		file.delete();
		
		int userband_num = Integer.parseInt(req.getParameter("userband_num"));
	    TempImgeDao dao = new TempImgeDao();
	    System.out.println("../upload"+src.substring(index + 6));
	    TmpImgVo vo = new TmpImgVo(0,userband_num,"../upload"+src.substring(index + 6),0);
	    
	    int n = dao.delete(vo);
	    if(n<=0) {
	    	vo.setTmp_state(1);
	    	dao.insert(vo);
	    }
	    
	}
	
}
