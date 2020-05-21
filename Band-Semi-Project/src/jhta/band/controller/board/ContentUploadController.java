package jhta.band.controller.board;

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

import jhta.band.dao.board.BoardDao;
import jhta.band.dao.board.CommentsDao;
import jhta.band.dao.board.ImgBoardDao;
import jhta.band.vo.board.BoardVo;
import jhta.band.vo.board.CommentsVo;
import jhta.band.vo.board.ImgBoardVo;

@WebServlet("/contentUpload.do")
public class ContentUploadController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int band_num = Integer.parseInt(req.getParameter("band_num"));
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		list = dao.select(band_num);
		System.out.println(band_num);
		
		
			JSONArray jarr = new JSONArray();
			if(list !=null) {
				for(BoardVo vo:list){
					JSONObject json = new JSONObject();
					json.put("band_num", vo.getBand_num());
					json.put("board_num", vo.getBoard_num());
					json.put("board_states", vo.getBoard_states());
					json.put("userband_num", vo.getUserband_num());
					json.put("board_content", vo.getBoard_content());
					json.put("board_redate", vo.getBoard_redate());
					
					ArrayList<ImgBoardVo> img = new ImgBoardDao().select(vo.getBoard_num());
					if(img != null) {
						JSONArray jarr_img= new JSONArray();
						for(ImgBoardVo o:img) {
							JSONObject json_img = new JSONObject();
							json_img.put("img_url", o.getImg_url());
							System.out.println(o.getImg_url());
							jarr_img.put(json_img);
						}
						json.put("img_url", jarr_img);
					}
					
					CommentsDao com_dao = new CommentsDao();
					ArrayList<CommentsVo> comments = com_dao.select(vo.getBoard_num(), 1, 2);
					int comments_cnt = com_dao.BoardCount(vo.getBoard_num());
					json.put("comments_cnt", comments_cnt);
					
					if(comments != null) {
						JSONArray jarr_com= new JSONArray();
						for(CommentsVo com:comments) {
							JSONObject json_com = new JSONObject();
							json_com.put("comments_num", com.getComments_num());
							json_com.put("userband_num", com.getUserband_num());
							json_com.put("board_num", com.getBoard_num());
							json_com.put("comments_content", com.getComments_content());
							json_com.put("ref", com.getRef());
							json_com.put("step", com.getStep());
							json_com.put("comments_date", com.getComments_date());
							jarr_com.put(json_com);   
						}
						json.put("comments",jarr_com);
					}
					
					jarr.put(json);
				}
			}
			resp.setContentType("test/palin;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.print(jarr);
		
	}
}
