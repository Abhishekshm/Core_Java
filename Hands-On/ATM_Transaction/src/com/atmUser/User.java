package com.atmUser;


public class User {

	private int userAccountNo;
	private String userName;
	private double ammount;
	private int atmPin;
	public User() {
		super();
		
	}
	public User(int userAccountNo, String userName, double ammount, int atmPin) {
		super();
		this.userAccountNo = userAccountNo;
		this.userName = userName;
		this.ammount = ammount;
		this.atmPin = atmPin;
	}
	public int getUserAccountNo() {
		return userAccountNo;
	}
	public void setUserAccountNo(int userAccountNo) {
		this.userAccountNo = userAccountNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public int getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
	@Override
	public String toString() {
		return "User [userAccountNo=" + userAccountNo + ", userName=" + userName + ", ammount=" + ammount + ", atmPin="
				+ atmPin + "]";
	}
	
	
	
}
