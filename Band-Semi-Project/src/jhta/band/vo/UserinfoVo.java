package jhta.band.vo;

import java.io.File;
import java.sql.Date;

public class UserinfoVo {
	private long login_num;
	private String user_name;
	private String user_phone;
	private String user_email;
	private String user_gender;
	private String user_quiz;
	private String user_anser;
	private File user_img;
	private Date birth;
	
	public UserinfoVo() {}
	// userinfo ( table )
	public UserinfoVo(long login_num, String user_name, String user_phone, String user_email, String user_gender,
			String user_quiz, String user_anser, File user_img, Date birth) {
		this.login_num = login_num;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_gender = user_gender;
		this.user_quiz = user_quiz;
		this.user_anser = user_anser;
		this.user_img = user_img;
		this.birth = birth;
	}
	
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public long getLogin_num() {
		return login_num;
	}


	public void setLogin_num(long login_num) {
		this.login_num = login_num;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_gender() {
		return user_gender;
	}


	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}


	public String getUser_quiz() {
		return user_quiz;
	}


	public void setUser_quiz(String user_quiz) {
		this.user_quiz = user_quiz;
	}


	public String getUser_anser() {
		return user_anser;
	}


	public void setUser_anser(String user_anser) {
		this.user_anser = user_anser;
	}


	public File getUser_img() {
		return user_img;
	}


	public void setUser_img(File user_img) {
		this.user_img = user_img;
	}
	
	
}
