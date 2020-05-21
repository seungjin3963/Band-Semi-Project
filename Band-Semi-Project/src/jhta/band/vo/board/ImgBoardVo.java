package jhta.band.vo.board;

import java.sql.Date;

public class ImgBoardVo {
	private long img_num;
	private long band_num;
	private long board_num;
	private String img_url;
	private Date img_regdate;
	private int img_states;
	
	public ImgBoardVo() {}

	public ImgBoardVo(long img_num, long band_num, long board_num, String img_url, Date img_regdate, int img_states) {
		super();
		this.img_num = img_num;
		this.band_num = band_num;
		this.board_num = board_num;
		this.img_url = img_url;
		this.img_regdate = img_regdate;
		this.img_states = img_states;
	}

	public long getImg_num() {
		return img_num;
	}

	public void setImg_num(long img_num) {
		this.img_num = img_num;
	}

	public long getBand_num() {
		return band_num;
	}

	public void setBand_num(long band_num) {
		this.band_num = band_num;
	}

	public long getBoard_num() {
		return board_num;
	}

	public void setBoard_num(long board_num) {
		this.board_num = board_num;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Date getImg_regdate() {
		return img_regdate;
	}

	public void setImg_regdate(Date img_regdate) {
		this.img_regdate = img_regdate;
	}

	public int getImg_states() {
		return img_states;
	}

	public void setImg_states(int img_states) {
		this.img_states = img_states;
	}
	
	
	
	
}
