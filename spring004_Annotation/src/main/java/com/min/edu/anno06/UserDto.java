package com.min.edu.anno06;

public class UserDto {
	private String name;

	public UserDto() {
		super();
	}

	public UserDto(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
