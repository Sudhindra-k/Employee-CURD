package sudhi.thymeleaf.emplooyee;


import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sudhi.thymeleaf.emplooyee.dao.EmployeeRepo;
import sudhi.thymeleaf.emplooyee.entity.Employee;
import sudhi.thymeleaf.emplooyee.service.EmployeeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class EmplooyeeApplicationTests {

	@Autowired
	private EmployeeServiceImpl empserv;
	
	@Autowired
	private EmployeeRepo emprepo;
	
	
	private List<Employee> emp;
	
	@Test
	@BeforeEach
	void init() {
		emp = empserv.findall();
	}
	
	
	@Test
	public void Check() {
		
		Employee exp = new Employee(1,"Leslie","Andrews","leslie@zxc.com");
		
		Employee act = emp.get(0);
		
		assertEquals(exp.getId(),act.getId());
		
		assertEquals(exp.getFirstname(),act.getFirstname());
		
		assertEquals(exp.getLastname(),act.getLastname());
		
		assertEquals(exp.getEmail(),act.getEmail());
		
	}
	

	@Test
	public void save() {
		
		int index;
		
		Employee emp1 = new Employee("Testfinal","Testfinal","test123@test.com");
		
		empserv.save(emp1);
		
		emp = empserv.findall();
		
		index=emp.size()-1;
		
		Employee act = emp.get(index);
			
		assertEquals(emp1.getFirstname(),act.getFirstname());
		
		assertEquals(emp1.getLastname(),act.getLastname());
		
		assertEquals(emp1.getEmail(),act.getEmail());
		
	}
	
	@Test
	public void delete() {
		
		Optional<Employee> result;
		
		int min=2;
		int max=20;
		int id = (int)( Math.random()*(max-min+1)+min);
		
		//Random rand = new Random();
		
		//int id = rand.nextInt(25);
				
		empserv.findall();
		
		result = emprepo.findById(id);
				
		System.out.println(" "+result);
		
		if(result.isPresent()) {
			empserv.deletebyId(id);
		}else {
			System.out.println(" Employee Id " +id+ "Deleted already or Doesnot exist" );
		}		
		
	}
	
	
	
}

