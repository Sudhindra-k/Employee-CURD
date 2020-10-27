package sudhi.thymeleaf.emplooyee;



import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import sudhi.thymeleaf.emplooyee.controller.AppController;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
class ControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private AppController app;
	
	@Before
	@Test
	void test() {
		System.out.println("sample");
		
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	
	//retrieving the list
	@WithMockUser(username="sample",roles="EMPLOYEE")
	@Test
	public void list() throws Exception{
		
		MvcResult result = mvc 
								.perform(get("/employees/list")
								.contentType(MediaType.APPLICATION_JSON))
								.andExpect(status().isOk())
								.andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
	}
	
	
	
	//retrieving the form
	@WithMockUser(username="sample",roles="MANAGER")
	@Test
	public void form() throws Exception{
		
		MvcResult result = mvc
								.perform(get("/employees/showform").contentType(MediaType.APPLICATION_JSON))
								.andExpect(status().isOk())
								.andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
		
	}
	
	
	

}
