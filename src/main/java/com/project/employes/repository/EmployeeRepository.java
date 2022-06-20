package com.project.employes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employes.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, CustomEmployeeRepository  {
	
	//Optional<Employee> findById(Long id);

}
