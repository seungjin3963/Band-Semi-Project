package jhta.band.controller.calender;



public class CalenderDvo {
	private int calender_num;
	private int band_num;
	private String calender_date;
	private String calender_title;
	private String calender_content;
	public CalenderDvo(){}
	public CalenderDvo(int calender_num, int band_num, String calender_date, String calender_title,
			String calender_content) {
		super();
		this.calender_num = calender_num;
		this.band_num = band_num;
		this.calender_date = calender_date;
		this.calender_title = calender_title;
		this.calender_content = calender_content;
		
	}
	public int getCalender_num() {
		return calender_num;
	}
	public void setCalender_num(int calender_num) {
		this.calender_num = calender_num;
	}
	public int getBand_num() {
		return band_num;
	}
	public void setBand_num(int band_num) {
		this.band_num = band_num;
	}
	public String getCalender_date() {
		return calender_date;
	}
	public void setCalender_date(String calender_date) {
		this.calender_date = calender_date;
	}
	public String getCalender_title() {
		return calender_title;
	}
	public void setCalender_title(String calender_title) {
		this.calender_title = calender_title;
	}
	public String getCalender_content() {
		return calender_content;
	}
	public void setCalender_content(String calender_content) {
		this.calender_content = calender_content;
	}
}
