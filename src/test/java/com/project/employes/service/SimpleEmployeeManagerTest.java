package com.project.employes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;


import com.project.employes.services.EmployeeManager;
import com.project.employes.services.SimpleEmployeeManager;

public class SimpleEmployeeManagerTest {

	private EmployeeManager employeeManager;
	

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		
		employeeManager = new SimpleEmployeeManager();
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void anual_salaryNull() {
		employeeManager = new SimpleEmployeeManager();
		// Se declara un sueldo de prueba
		float salaryTest = 10.0f;
		float salida = employeeManager.anual_salary(salaryTest);
		assertNotNull(salida);
	}	
	
	@Test
	void anual_salary() {
		employeeManager = new SimpleEmployeeManager();
		// Se declara un sueldo de prueba
		float salaryTest = 10.0f;
		// Se declara un sueldo de validacion
		float salaryTestValidation = 120.0f;	
		
		float salida = employeeManager.anual_salary(salaryTest);
		assertEquals(salaryTestValidation, salida);
	}	
	
}
