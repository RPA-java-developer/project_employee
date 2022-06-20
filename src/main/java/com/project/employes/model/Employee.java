package com.project.employes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employee_name", length = 60, nullable = false)
	private String employee_name;

	@Column(name = "employee_salary", length = 20, nullable = false)
	private float employee_salary;

	@Column(name = "employee_age", length = 3, nullable = false)
	private Integer employee_age;

	@Column(name = "profile_image", length = 60, nullable = false)
	private String profile_image;

	private String nuevaFuenteDatos;
	
	public Employee() {
	}

	public Employee(Long id, String employee_name, float employee_salary, Integer employee_age, String profile_image) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_age = employee_age;
		this.profile_image = profile_image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return employee_name;
	}

	public void setName(String employee_name) {
		this.employee_name = employee_name;
	}

	public float getSalary() {
		return employee_salary;
	}

	public void setSalary(float employee_salary) {
		this.employee_salary = employee_salary;
	}

	public Integer getAge() {
		return employee_age;
	}

	public void setAge(Integer employee_age) {
		this.employee_age = employee_age;
	}

	public String getImage() {
		return profile_image;
	}

	public void setImage(String profile_image) {
		this.profile_image = profile_image;
	}

	/*
	public String nuevaFuenteDatos() {
		return "hola";
	}
	*/
}
