package com.min.edu.bean03;

import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Required;

public class UserDto {

	private String name;
	private Properties per;
	private Date myDate;
	private String hobby;
	
	
	public UserDto(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getPer() {
		return per;
	}

	public void setPer(Properties per) {
		this.per = per;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String getHobby() {
		return hobby;
	}
	
	@Required
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", per=" + per + ", myDate=" + myDate + ", hobby=" + hobby + "]";
	}
	
}
