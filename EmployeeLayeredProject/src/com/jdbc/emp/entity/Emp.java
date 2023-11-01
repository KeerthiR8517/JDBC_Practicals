package com.jdbc.emp.entity;

public class Emp 
{
	Integer eno,salary;
	String ename,dept;
	public Integer getEno() {
	 return eno;
		
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	

}
