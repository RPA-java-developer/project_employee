package com.project.employes.repository.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.client.RestTemplate;
import com.project.employes.repository.CustomEmployeeRepository;


public class CustomPostRepositoryImpl implements CustomEmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;
    
	@Override
	public String nuevaFuenteDatos(String nuevoOrigen) {
		String result = "";
		
		String uri = "https://dummy.restapiexample.com/api/v1/employees";
		RestTemplate restTemplate = new RestTemplate();
		try {
			result = restTemplate.getForObject(uri, String.class);
        } catch (Exception handlerException) {
            System.out.println("Error2: " + handlerException);
            result = "429 Too Many Requests:";
        }
		System.out.println("---> " + result);
		
		return result;
	}
	
	

}
