package jhta.band.vo.board;

import java.util.Date;

public class BoardVo {
	private long board_num;
	private long band_num;
	private long userband_num;
	private String board_content;
	private Date board_redate;
	private int board_states;
	private String band_nickname;
	private long prevNum;
	private long nextNum;
	
	
	public BoardVo() {}

	public BoardVo(long board_num, long band_num, long userband_num, String board_content, Date board_redate,
			int board_states) {
		super();
		this.board_num = board_num;
		this.band_num = band_num;
		this.userband_num = userband_num;
		this.board_content = board_content;
		this.board_redate = board_redate;
		this.board_states = board_states;
	}

	public long getBoard_num() {
		return board_num;
	}

	public void setBoard_num(long board_num) {
		this.board_num = board_num;
	}

	public long getBand_num() {
		return band_num;
	}

	public void setBand_num(long band_num) {
		this.band_num = band_num;
	}

	public long getUserband_num() {
		return userband_num;
	}

	public void setUserband_num(long userband_num) {
		this.userband_num = userband_num;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getBoard_redate() {
		return board_redate;
	}

	public void setBoard_redate(Date board_redate) {
		this.board_redate = board_redate;
	}

	public int getBoard_states() {
		return board_states;
	}

	public void setBoard_states(int board_states) {
		this.board_states = board_states;
	}

	public String getBand_nickname() {
		return band_nickname;
	}

	public void setBand_nickname(String band_nickname) {
		this.band_nickname = band_nickname;
	}

	public long getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(long prevNum) {
		this.prevNum = prevNum;
	}

	public long getNextNum() {
		return nextNum;
	}

	public void setNextNum(long nextNum) {
		this.nextNum = nextNum;
	}
	
	
	
}
