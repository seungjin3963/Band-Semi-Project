package jhth.band.vo.ssjVo;

public class CoverVo {
	private int covercount=0;
	private int covernum=0;
	private String coverURL;
	
	public CoverVo() {}

	public CoverVo(int covercount, int covernum, String coverURL) {
		this.covercount = covercount;
		this.covernum = covernum;
		this.coverURL = coverURL;
	}



	public int getCovercount() {
		return covercount;
	}

	public void setCovercount(int covercount) {
		this.covercount = covercount;
	}

	public int getCovernum() {
		return covernum;
	}

	public void setCovernum(int covernum) {
		this.covernum = covernum;
	}

	public String getCoverURL() {
		return coverURL;
	}

	public void setCoverURL(String coverURL) {
		this.coverURL = coverURL;
	}
	
}
