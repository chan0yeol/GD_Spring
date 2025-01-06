package com.min.edu.anno05;

/*
 * Spring bean Configuration에 XML 작성을 통해서 Bean으로 등록하여 사용하게 될 클래스
 * @Component를 통해서 Bean을 생성하면 하나만 생성되기 때문에 XML을 통해 여러개의 Bean을 만들어 냄
 * id를 통해서 이름이 부여됨
 */
public class Student {
	@Override
	public String toString() {
		return "Student [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}

	private String name;
	private String addr;
	private String phone;

	public Student() {
		super();
	}

	public Student(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
