package jhta.band.controller.memberslist;

public class mainpagemembersDvo {
	private String name;
	private int user_num;
	private int divdelete;
	public mainpagemembersDvo(String name,int user_num , int divdelete) {
		this.name = name;	
		this.user_num = user_num;
		this.divdelete = divdelete;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getDivdelete() {
		return divdelete;
	}
	public void setDivdelete(int divdelete) {
		this.divdelete = divdelete;
	}
	
}
