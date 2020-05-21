package jhta.band.vo.board;

import java.sql.Date;

public class CommentsVo {
	private long comments_num;
	private long userband_num;
	private long board_num;
	private String comments_content;
	private long ref;
	private int step;
	private Date comments_date;
	private int comments_state;
	private String band_nickname;
	
	public CommentsVo() {}


	public CommentsVo(long comments_num, long userband_num, long board_num, String comments_content, long ref, int step,
			Date comments_date, int comments_state) {
		super();
		this.comments_num = comments_num;
		this.userband_num = userband_num;
		this.board_num = board_num;
		this.comments_content = comments_content;
		this.ref = ref;
		this.step = step;
		this.comments_date = comments_date;
		this.comments_state = comments_state;
	}


	public long getComments_num() {
		return comments_num;
	}


	public void setComments_num(long comments_num) {
		this.comments_num = comments_num;
	}


	public long getUserband_num() {
		return userband_num;
	}


	public void setUserband_num(long userband_num) {
		this.userband_num = userband_num;
	}


	public long getBoard_num() {
		return board_num;
	}


	public void setBoard_num(long board_num) {
		this.board_num = board_num;
	}


	public String getComments_content() {
		return comments_content;
	}


	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}


	public long getRef() {
		return ref;
	}


	public void setRef(long ref) {
		this.ref = ref;
	}


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public Date getComments_date() {
		return comments_date;
	}


	public void setComments_date(Date comments_date) {
		this.comments_date = comments_date;
	}


	public int getComments_state() {
		return comments_state;
	}


	public void setComments_state(int comments_state) {
		this.comments_state = comments_state;
	}


	public String getBand_nickname() {
		return band_nickname;
	}


	public void setBand_nickname(String band_nickname) {
		this.band_nickname = band_nickname;
	}
	
	
	
	
}
