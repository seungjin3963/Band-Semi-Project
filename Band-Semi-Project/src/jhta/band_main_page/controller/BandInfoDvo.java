package jhta.band_main_page.controller;

public class BandInfoDvo {
	private int band_approved;
	private int User_Band_num;
	public BandInfoDvo(int band_approved, int user_Band_num) {
		this.band_approved = band_approved;
		this.User_Band_num = user_Band_num;
	}
	public int getBand_approved() {
		return band_approved;
	}
	public void setBand_approved(int band_approved) {
		this.band_approved = band_approved;
	}
	public int getUser_Band_num() {
		return User_Band_num;
	}
	public void setUser_Band_num(int user_Band_num) {
		User_Band_num = user_Band_num;
	}
	
}