package com.cts.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	
	
	@Min(value=100, message="Minimum value is 100")
	private int id;
	@Min(value=10000, message="Minimum value is 10000")
	@Max(value=20000, message="Maximum value is 20000")
     private int salary;
	
	@NotNull(message="Enter the Name")
	@Size(min=3,max=10,message="Enter with min 3 and max 5")
    private String name;
	
	@NotNull(message="Enter the Desgination please")
	private String desg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	

}
