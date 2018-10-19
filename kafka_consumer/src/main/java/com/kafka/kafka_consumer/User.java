package com.kafka.kafka_consumer;

public class User {
	
	public String name;
	public String dept;
	public String salary;
	public User() {
		
	}
	public User(String name, String dept, String salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	

}
