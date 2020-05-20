package jhth.band.vo.MakeBandVo;

public class BcategoryVo {
	private int bcategoryNum;
	private String category_btitle;
	private String categoryimg;

	public BcategoryVo() {}
	
	public BcategoryVo(int bcategoryNum, String category_btitle, String categoryimg) {
		this.bcategoryNum = bcategoryNum;
		this.category_btitle = category_btitle;
		this.categoryimg = categoryimg;
	}

	public int getBcategoryNum() {
		return bcategoryNum;
	}

	public void setBcategoryNum(int bcategoryNum) {
		this.bcategoryNum = bcategoryNum;
	}

	public String getCategory_btitle() {
		return category_btitle;
	}

	public void setCategory_btitle(String category_btitle) {
		this.category_btitle = category_btitle;
	}

	public String getCategoryimg() {
		return categoryimg;
	}

	public void setCategoryimg(String categoryimg) {
		this.categoryimg = categoryimg;
	}
}
