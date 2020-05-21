package jhta.band.controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jhta.band.dao.board.BoardDao;
import jhta.band.dao.board.TempImgeDao;
import jhta.band.vo.board.BoardVo;
import jhta.band.vo.board.TmpImgVo;

@WebServlet("/board/BoardUpload.do")
public class BoardUploadController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String userband_num = req.getParameter("userband_num");

		String band_num = req.getParameter("band_num");
		String board_content = req.getParameter("code");
		String noticeChk = req.getParameter("boardState");

		TempImgeDao tmp_dao = new TempImgeDao();
		System.out.println(band_num+board_content+userband_num);
		ArrayList<TmpImgVo> list = tmp_dao.selectList(Integer.parseInt(userband_num));
		System.out.println("1234");
		BoardVo bvo = new BoardVo(0, Long.parseLong(band_num), Long.parseLong(userband_num), board_content, null,
				Integer.parseInt(noticeChk));
		BoardDao dao = new BoardDao();

		dao.insertSet(bvo, list);

		tmp_dao.delete(Integer.parseInt(userband_num));

		JSONObject json = new JSONObject();
		json.put("result", "success");
		resp.setContentType("test/palin;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print(json);
	}
}
