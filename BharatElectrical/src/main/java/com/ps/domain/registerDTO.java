package com.ps.domain;

public class registerDTO {
	private String fname,mname,lname,type,addr,email,pass,repass,countryCode;
	private long phoneNo;
	
	
	public void setFname(String firstName) {
		this.fname = firstName;
	}
	public String getFname() {
		return fname;
	}
	public void setMname(String middleName) {
		this.mname = middleName;
	}
	public String getMname() {
		return mname;
	}
	public void setLname(String lastName) {
		this.lname = lastName;
	}
	public String getLname() {
		return lname;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setAddr(String address) {
		this.addr = address;
	}
	public String getAddr() {
		return addr;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPass(String password) {
		this.pass = password;
	}
	public String getPass() {
		return pass;
	}
	public void setRepass(String retypePassword) {
		this.repass = retypePassword;
	}
	public String getRepass() {
		return repass;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setPhoneNo(long phone) {
		this.phoneNo = phone;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
}
