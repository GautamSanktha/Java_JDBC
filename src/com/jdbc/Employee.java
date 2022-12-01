package com.jdbc;

public class Employee {
	private int id;
	private String name;
	private int salary;
	private String mail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Employee(int id,String name,int salary,String mail)
	{
		super();
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.mail=mail;
	}
	public Employee() {
		super();
	}

}
