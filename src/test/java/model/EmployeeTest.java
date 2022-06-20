package model;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.project.employes.model.Employee;

class EmployeeTest {
	
	private Employee test_employee;
	


	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		
		test_employee = new Employee();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testEmployeeLongStringFloatIntegerString() {
		//fail("Not yet implemented");
		Employee test_employee = new Employee();
		test_employee.setId(5L);
		test_employee.setName("nombre");
		test_employee.setSalary(3000.5f);
		test_employee.setAge(24);
		test_employee.setImage("");
		
		assertEquals("nombre", test_employee.getName());
	}

	@Test
	void testGetName() {
		Employee test_employee2 = new Employee();
		test_employee2.setName("OTRO_NOMBRE");
		assertEquals("OTRO_NOMBRE", test_employee2.getName());
	}

	@Test
	void testGetSalary() {
		Employee test_employee2 = new Employee();
		test_employee2.setSalary(123.56f);
		assertEquals(123.56f, test_employee2.getSalary());
	}

}
