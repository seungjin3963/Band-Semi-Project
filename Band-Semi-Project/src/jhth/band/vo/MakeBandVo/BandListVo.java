package jhth.band.vo.MakeBandVo;

public class BandListVo {
	
	private long band_num=0;
	private String bandname;
	private String bandimg;
	private long bandcount=0;
	
	public BandListVo() {}

	public BandListVo(long band_num, String bandname, String bandimg, long bandcount) {
		this.band_num = band_num;
		this.bandname = bandname;
		this.bandimg = bandimg;
		this.bandcount = bandcount;
	}

	public long getBand_num() {
		return band_num;
	}

	public void setBand_num(long band_num) {
		this.band_num = band_num;
	}

	public String getBandname() {
		return bandname;
	}

	public void setBandname(String bandname) {
		this.bandname = bandname;
	}

	public String getBandimg() {
		return bandimg;
	}

	public void setBandimg(String bandimg) {
		this.bandimg = bandimg;
	}

	public long getBandcount() {
		return bandcount;
	}

	public void setBandcount(long bandcount) {
		this.bandcount = bandcount;
	}
	
}
