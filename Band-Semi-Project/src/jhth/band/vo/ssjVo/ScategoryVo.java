package jhth.band.vo.ssjVo;

public class ScategoryVo {
	long scategoryNum;
	int bcategoryNum;
	String category_stitle;
	
	public ScategoryVo() {}

	public ScategoryVo(long scategoryNum, int bcategoryNum, String category_stitle) {
		this.scategoryNum = scategoryNum;
		this.bcategoryNum = bcategoryNum;
		this.category_stitle = category_stitle;
	}

	public long getScategoryNum() {
		return scategoryNum;
	}

	public void setScategoryNum(long scategoryNum) {
		this.scategoryNum = scategoryNum;
	}

	public int getBcategoryNum() {
		return bcategoryNum;
	}

	public void setBcategoryNum(int bcategoryNum) {
		this.bcategoryNum = bcategoryNum;
	}

	public String getCategory_stitle() {
		return category_stitle;
	}

	public void setCategory_stitle(String category_stitle) {
		this.category_stitle = category_stitle;
	}
	
}
