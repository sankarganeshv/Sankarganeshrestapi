package com.faith.bean;

public class User 
	{
	 //instance Variables
	Integer rollId;
	String userName;
	String password;
	//getters and setters
	public Integer getRollId() {
		return rollId;
	}
	public void setRollId(Integer rollId) {
		this.rollId = rollId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [rollId=" + rollId + ", username=" + userName + ", password=" + password + "]";
	}
	public User(Integer rollId, String username, String password) {
		super();
		this.rollId = rollId;
		this.userName = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
