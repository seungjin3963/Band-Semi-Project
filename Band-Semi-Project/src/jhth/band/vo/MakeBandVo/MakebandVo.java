package jhth.band.vo.MakeBandVo;

import java.util.Date;

public class MakebandVo {
	private long band_num=0;
	private int scategoryNum=0;
	private String band_name;
	private int band_publicwhe=0;
	private String band_introductio;
	private int band_imgNum=0;
	private Date band_date;
	private int band_states=0;
	
	public MakebandVo() {}

	public MakebandVo(long band_num, int scategoryNum, String band_name, int band_publicwhe, String band_introductio,
			int band_imgNum, Date band_date, int band_states) {
		this.band_num = band_num;
		this.scategoryNum = scategoryNum;
		this.band_name = band_name;
		this.band_publicwhe = band_publicwhe;
		this.band_introductio = band_introductio;
		this.band_imgNum = band_imgNum;
		this.band_date = band_date;
		this.band_states = band_states;
	}

	public long getBand_num() {
		return band_num;
	}

	public void setBand_num(long band_num) {
		this.band_num = band_num;
	}

	public int getScategoryNum() {
		return scategoryNum;
	}

	public void setScategoryNum(int scategoryNum) {
		this.scategoryNum = scategoryNum;
	}

	public String getBand_name() {
		return band_name;
	}

	public void setBand_name(String band_name) {
		this.band_name = band_name;
	}

	public int getBand_publicwhe() {
		return band_publicwhe;
	}

	public void setBand_publicwhe(int band_publicwhe) {
		this.band_publicwhe = band_publicwhe;
	}

	public String getBand_introductio() {
		return band_introductio;
	}

	public void setBand_introductio(String band_introductio) {
		this.band_introductio = band_introductio;
	}

	public int getBand_imgNum() {
		return band_imgNum;
	}

	public void setBand_imgNum(int band_imgNum) {
		this.band_imgNum = band_imgNum;
	}

	public Date getBand_date() {
		return band_date;
	}

	public void setBand_date(Date band_date) {
		this.band_date = band_date;
	}

	public int getBand_states() {
		return band_states;
	}

	public void setBand_states(int band_states) {
		this.band_states = band_states;
	}
	
}
