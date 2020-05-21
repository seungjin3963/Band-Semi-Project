package jhta.band.bandSerch.Vo;

public class bandSerchVo {
	private int band_num;
	private String band_name;
	private String band_intoroductio;
	private int login_num;
	public bandSerchVo(int band_num, String band_name, String band_intoroductio, int login_num) {
		super();
		this.band_num = band_num;
		this.band_name = band_name;
		this.band_intoroductio = band_intoroductio;
		this.login_num = login_num;
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
	public int getLogin_num() {
		return login_num;
	}
	public void setLogin_num(int login_num) {
		this.login_num = login_num;
	}
	
	
}
