package jhth.band.vo.ssjVo;

import java.util.Date;

public class Band_userinfoVo {
	long userBand_num=0;
	long band_num=0;
	long login_num=0;
	String band_nickname;
	int band_approved=0;
	Date band_redate;
	
	public Band_userinfoVo() {}

	public Band_userinfoVo(long userBand_num, long band_num, long login_num, String band_nickname, int band_approved,
			Date band_redate) {
		this.userBand_num = userBand_num;
		this.band_num = band_num;
		this.login_num = login_num;
		this.band_nickname = band_nickname;
		this.band_approved = band_approved;
		this.band_redate = band_redate;
	}

	public long getUserBand_num() {
		return userBand_num;
	}

	public void setUserBand_num(long userBand_num) {
		this.userBand_num = userBand_num;
	}

	public long getBand_num() {
		return band_num;
	}

	public void setBand_num(long band_num) {
		this.band_num = band_num;
	}

	public long getLogin_num() {
		return login_num;
	}

	public void setLogin_num(long login_num) {
		this.login_num = login_num;
	}

	public String getBand_nickname() {
		return band_nickname;
	}

	public void setBand_nickname(String band_nickname) {
		this.band_nickname = band_nickname;
	}

	public int getBand_approved() {
		return band_approved;
	}

	public void setBand_approved(int band_approved) {
		this.band_approved = band_approved;
	}

	public Date getBand_redate() {
		return band_redate;
	}

	public void setBand_redate(Date band_redate) {
		this.band_redate = band_redate;
	}
	
}
