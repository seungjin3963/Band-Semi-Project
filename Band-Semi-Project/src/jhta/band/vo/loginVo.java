package jhta.band.vo;

import java.sql.Date;

public class loginVo {
	private long login_num;
	private String login_id;
	private String login_pwd;
	private Date login_date;
	private int login_state;
	
	public loginVo() {}
	
	public loginVo(long login_num, String login_id, String login_pwd, Date login_date, int login_state) {
		this.login_num = login_num;
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.login_date = login_date;
		this.login_state = login_state;
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
	
	
}
