package sudhi.thymeleaf.emplooyee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sudhi.thymeleaf.emplooyee.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	//public Employee findById(int id);
	

}
