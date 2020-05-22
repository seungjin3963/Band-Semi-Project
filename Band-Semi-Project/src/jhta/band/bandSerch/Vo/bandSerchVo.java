package jhta.band.bandSerch.Vo;

public class bandSerchVo {
	private int band_num;
	private String band_name;
	private String band_intoroductio;
	private String bandimg;
	public bandSerchVo() {
		// TODO Auto-generated constructor stub
	}
	
	public bandSerchVo(int band_num, String band_name, String band_intoroductio, String bandimg) {
		super();
		this.band_num = band_num;
		this.band_name = band_name;
		this.band_intoroductio = band_intoroductio;
		this.bandimg = bandimg;
	}

	public int getBand_num() {
		return band_num;
	}

	public void setBand_num(int band_num) {
		this.band_num = band_num;
	}

	public String getBand_name() {
		return band_name;
	}

	public void setBand_name(String band_name) {
		this.band_name = band_name;
	}

	public String getBand_intoroductio() {
		return band_intoroductio;
	}

	public void setBand_intoroductio(String band_intoroductio) {
		this.band_intoroductio = band_intoroductio;
	}

	public String getBandimg() {
		return bandimg;
	}

	public void setBandimg(String bandimg) {
		this.bandimg = bandimg;
	}
	
	
}
