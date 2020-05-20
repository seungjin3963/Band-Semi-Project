package jhta.band.vo;

import java.io.File;
import java.sql.Date;

public class JoinVo {
	private long login_num;
	private String login_id;
	private String login_pwd;
	private Date login_date;
	private int login_state;
	private String user_name;
	private String user_phone;
	private String user_email;
	private String user_gender;
	private String user_quiz;
	private String user_anser;
	private Date user_birth;
	
	public JoinVo() {}
	
	public JoinVo(long login_num, String login_id, String login_pwd, Date login_date, int login_state, String user_name,
			String user_phone, String user_email, String user_gender, String user_quiz, String user_anser,
			Date user_birth) {
		this.login_num = login_num;
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.login_date = login_date;
		this.login_state = login_state;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_gender = user_gender;
		this.user_quiz = user_quiz;
		this.user_anser = user_anser;
		this.user_birth = user_birth;
	}

	public long getLogin_num() {
		return login_num;
	}

	public void setLogin_num(long login_num) {
		this.login_num = login_num;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public Date getLogin_date() {
		return login_date;
	}

	public void setLogin_date(Date login_date) {
		this.login_date = login_date;
	}

	public int getLogin_state() {
		return login_state;
	}

	public void setLogin_state(int login_state) {
		this.login_state = login_state;
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

	public Date getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}
	
}
