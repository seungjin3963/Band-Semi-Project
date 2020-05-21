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

@WebServlet("/summernoteUpload.do")
public class ImgUploadSummernote extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html);charset=utf-8");
		
		String upload = req.getServletContext().getRealPath("/upload");
		System.out.println(upload);
		int size = 10 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(req,upload,size,"utf-8",new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String file = (String)files.nextElement(); 	
			String org_filename = multi.getOriginalFileName(file);
			String save_filename = multi.getFilesystemName(file);
			
			String uploadPath = upload +"/"+save_filename;
			
			String path = "../upload/" + save_filename;
			
			TempImgeDao dao = new TempImgeDao();
			System.out.println(multi.getParameter("userband_num"));
			int userband_num = Integer.parseInt(multi.getParameter("userband_num"));
			TmpImgVo vo = new TmpImgVo(0,userband_num,path,0);
			
			int n = dao.insert(vo);
			
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print("../upload/"+save_filename);
			
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
