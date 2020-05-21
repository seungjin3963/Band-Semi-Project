package jhta.band_main_page.controller;

public class BandAllinfoDvo {
	private String band_name;
	private String band_intoroductio;
	private String bandimg;
	public BandAllinfoDvo(String band_name, String band_intoroductio, String bandimg) {
		
		this.band_name = band_name;
		this.band_intoroductio = band_intoroductio;
		this.bandimg = bandimg;
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
