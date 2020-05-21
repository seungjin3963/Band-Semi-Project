package jhta.band.vo.board;

public class TmpImgVo {
	private int tmp_num;
	private int userband_num;
	private String tmpimg_url;
	private int tmp_state;
	
	public int getTmp_state() {
		return tmp_state;
	}

	public void setTmp_state(int tmp_state) {
		this.tmp_state = tmp_state;
	}

	public TmpImgVo() {}

	

	public TmpImgVo(int tmp_num, int userband_num, String tmpimg_url, int tmp_state) {
		super();
		this.tmp_num = tmp_num;
		this.userband_num = userband_num;
		this.tmpimg_url = tmpimg_url;
		this.tmp_state = tmp_state;
	}

	public int getTmp_num() {
		return tmp_num;
	}

	public void setTmp_num(int tmp_num) {
		this.tmp_num = tmp_num;
	}

	public int getUserband_num() {
		return userband_num;
	}

	public void setUserband_num(int userband_num) {
		this.userband_num = userband_num;
	}

	public String getTmpimg_url() {
		return tmpimg_url;
	}

	public void setTmpimg_url(String tmpimg_url) {
		this.tmpimg_url = tmpimg_url;
	}
	
	
	
	
}
