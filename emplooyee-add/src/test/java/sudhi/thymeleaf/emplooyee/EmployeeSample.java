package sudhi.thymeleaf.emplooyee;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import sudhi.thymeleaf.emplooyee.entity.Employee;
import sudhi.thymeleaf.emplooyee.service.EmployeeServiceImpl;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeSample {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private EmployeeServiceImpl empserv;
	
	private List<Employee> emp;
	
	@Test
	void test() {
		//fail("Not yet implemented");
		System.out.println("Sample");
	}
	
	@Before
	@Test
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		System.out.println("setup");
	}
	
	@WithMockUser(username="sample",roles="ADMIN")
	@Test
	public void save() throws Exception{
		Employee emp = new Employee(10,"Sample","k","sample@qwe.com");
		
		String json = mapper.writeValueAsString(emp);
		
		System.out.println(" "+json);
		
		MvcResult result = mvc
							.perform(post("/employees/deleteEmp")
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk()).andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
	}
	
	
	/*@WithMockUser(username="sample",roles="EMPLOYEE")
	@Test
	public void list() throws Exception{
		
		MvcResult result = mvc
								.perform(get("/employees/list")
								.contentType(MediaType.APPLICATION_JSON))
								.andExpect(status().isOk())
								.andReturn()
		
		System.out.println("List");
		assertEquals(200,result.getResponse().getStatus());
	}
	
	
	
	@WithMockUser(username="sample",roles="MANAGER")
	@Test
	public void form() throws Exception{
		
		MvcResult result = mvc
								.perform(get("/employees/showform")
								.contentType(MediaType.APPLICATION_JSON))
								.andExpect(status().isOk())
								.andReturn();
		
		System.out.println("List");
		assertEquals(200,result.getResponse().getStatus());
	}
	
	
	@WithMockUser(username="sample",roles="EMPLOYEE")
	@Test
	public void listreturn() throws Exception{
		
		MvcResult result = mvc
								.perform(get("/employees/list")
								.contentType(MediaType.APPLICATION_JSON))
								.andReturn().
								
		
		System.out.println(" "+result);
		
	}*/
	
	
	
	
	
}
