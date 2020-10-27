package sudhi.thymeleaf.emplooyee.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("date", new java.util.Date());
		
		return "hello";
	}

}
