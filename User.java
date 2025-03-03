package main;

public class User { //도서실 개인회원
	private String id = null;
	private String pass = null;
	
	User(String id, String pass){
		this.id=id;
		this.pass=pass;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
