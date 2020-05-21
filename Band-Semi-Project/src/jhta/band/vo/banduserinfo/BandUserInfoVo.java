package jhta.band.vo.banduserinfo;

import java.sql.Date;

public class BandUserInfoVo {
	private long userband_num;
	private long band_num;
	private long login_num;
	private String band_nickname;
	private int band_approved;
	private Date band_redate;
	
	public BandUserInfoVo() {}

	public BandUserInfoVo(long userband_num, long band_num, long login_num, String band_nickname, int band_approved,
			Date band_redate) {
		super();
		this.userband_num = userband_num;
		this.band_num = band_num;
		this.login_num = login_num;
		this.band_nickname = band_nickname;
		this.band_approved = band_approved;
		this.band_redate = band_redate;
	}

	public long getUserband_num() {
		return userband_num;
	}

	public void setUserband_num(long userband_num) {
		this.userband_num = userband_num;
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
