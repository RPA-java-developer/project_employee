package com.project.employes.services;


public class SimpleEmployeeManager implements EmployeeManager {

	@Override
	public float anual_salary(float salary) {
		float anualSalary = salary * 12;
		return anualSalary;
	}

	
}
