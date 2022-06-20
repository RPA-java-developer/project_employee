package com.project.employes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.json.JSONArray;

import com.project.employes.exceptions.ResourceNotFoundException;
import com.project.employes.model.Employee;
import com.project.employes.repository.CustomEmployeeRepository;
import com.project.employes.repository.EmployeeRepository;
import com.project.employes.repository.impl.CustomPostRepositoryImpl;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	

	private CustomEmployeeRepository repository2;
	
	// This method is used to list all employees
	@GetMapping("/employees")
	//public List<Employee> listAllEmployees() {
	public String listAllEmployees() {	
		//return repository.findAll();

		JSONObject respuestaJson = new JSONObject();
		respuestaJson.put("status", "success");
		respuestaJson.put("data", repository.findAll());
		respuestaJson.put("message", "Successfully! Record has been fetched.");
		System.out.println(respuestaJson);
		
	    System.out.println(" ");		
				
	    return respuestaJson.toString();		
		//return "respuestaR";
	}
	
	
	@GetMapping("/callclientHello")
	private String getHelloClient() {
		String result = "";
		
		String uri = "https://dummy.restapiexample.com/api/v1/employees";
		RestTemplate restTemplate = new RestTemplate();
		try {
			result = restTemplate.getForObject(uri, String.class);
        } catch (Exception handlerException) {
            System.out.println("Error: " + handlerException);
            result = "429 Too Many Requests:";
        }
		System.out.println(">>>> " + result);
		
		return result;
	}
	
	/*
	public void doSomething() {
		long k = 1;
		Optional<Employee> persons = repository.findById(k);
	}
	*/
	
	
	@GetMapping("/otherData")
	public String newDataOrigin() {
		String listOfEmployees = "";
		String otroOrigen = "otroOrigen";
		repository2 = new CustomPostRepositoryImpl();

		try {
			listOfEmployees =  repository2.nuevaFuenteDatos(otroOrigen);
        } catch (Exception handlerException) {
            System.out.println("Error3: " + handlerException);
            listOfEmployees = "Sin datos";
        }		

		return listOfEmployees;
	}
	
	
	
	// Este metodo sirve para guardar un empleado
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		System.out.println("Entra por SAVE " + employee.getName());


		//employee_anual_salary = employee_salary x 12
		
		System.out.println("Salary: " + employee.getSalary());
				
	    return repository.save(employee);
	}
	
	
	// This method is used for find an Employee by ID 
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> obtenerEmpleadoPorID(@PathVariable Long id){
		System.out.println("llega id: " + id);
		Employee employee = null;
		if (id != null) {
			employee = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
			//return ResponseEntity.ok(employee);			
		} else {
			listAllEmployees();
		}
		return ResponseEntity.ok(employee);
	}	
	
	// This method is used for find an Employee by ID 
	@GetMapping("/employee/")
	public String obtenerListadoPorDefecto(){
		System.out.println("No llega id: ");

			JSONObject respuestaJson = new JSONObject();
			respuestaJson.put("status", "success");
			respuestaJson.put("data", repository.findAll());
			respuestaJson.put("message", "Successfully! Record has been fetched.");
			System.out.println(respuestaJson);
			
		    System.out.println(" ");		
		    return respuestaJson.toString();		
	}		

}
