package jhth.band.vo.MakeBandVo;

public class PhotoVo {
	private int bcategorynum;
	private String bcategory_btitle;
	private byte[] categoryimg;
	
	public PhotoVo() {}

	public PhotoVo(int bcategorynum, String bcategory_btitle, byte[] categoryimg) {
		this.bcategorynum = bcategorynum;
		this.bcategory_btitle = bcategory_btitle;
		this.categoryimg = categoryimg;
	}

	public int getBcategorynum() {
		return bcategorynum;
	}

	public void setBcategorynum(int bcategorynum) {
		this.bcategorynum = bcategorynum;
	}

	public String getBcategory_btitle() {
		return bcategory_btitle;
	}

	public void setBcategory_btitle(String bcategory_btitle) {
		this.bcategory_btitle = bcategory_btitle;
	}

	public byte[] getCategoryimg() {
		return categoryimg;
	}

	public void setCategoryimg(byte[] categoryimg) {
		this.categoryimg = categoryimg;
	}

}
