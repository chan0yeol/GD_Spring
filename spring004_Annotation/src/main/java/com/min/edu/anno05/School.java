package com.min.edu.anno05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * 생성된 Bean을 주입하여 사용한다.
 * 주입 방법은 @Autowired 타입기반
 * 			 @Resource 이름기반
 * 
 * Bean을 생성하는 stereotype이 아니라면 클래스 내에 Annotation을 사용할 수 있도록 해줘야 한다.
 * <context:annotation-driven>이 되어 있어야 한다.
 * 
 */
public class School {
	
	// TODO 001 여러개의 같은 타입이 존재하거나 없는 경우 오류 발생 
//	@Autowired
//	private Student student;
	
	// TODO 002 없는 경우 오류 발생, 없을 경우 null로 해당 주입을 처리하고싶다면 required = false
//	@Autowired(required = false)
//	private Student student;
	
	// TODO 003 @Autowired를 통해 특정한 이름의 Bean을 주입하겠다.
//	@Autowired()
//	@Qualifier("stu01")
//	private Student student;
	
	// TODO 004 @Resource를 통한 bean 주입
//	@Resource(name ="stu02")
//	private Student student;
	
	// TODO 005 @Resource를 통한 bean 주입
	@Resource()
	@Qualifier("stu02")
	private Student student;
	
	
	private int grade;

	public School() {
		super();
	}

	public School(Student student, int grade) {
		super();
		this.student = student;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [student=" + student + ", grade=" + grade + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
