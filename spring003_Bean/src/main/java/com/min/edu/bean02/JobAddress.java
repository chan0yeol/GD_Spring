package com.min.edu.bean02;

public class JobAddress {
	
	private Employee emp;
	private String jobName;
	
	public JobAddress() {
		emp = new Employee("고라파덕","물","0101");
	}

	public JobAddress(Employee emp, String jobName) {
		super();
		this.emp = emp;
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "JobAddress [emp=" + emp + ", jobName=" + jobName + "]";
	}
	
	
}
