package com.rohitwebAppToDo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	Model - Pass anything into controller > ModelMap
	@RequestMapping(value="login", method = RequestMethod.GET)
//	public String gotoLogin(@RequestParam String name, ModelMap model) {
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			System.out.println("name "+ name+" pass "+ password );
			model.put("name", name);
//		    model.put("password", password);
			
			
			
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials! Please try again.");		
		return "login";
	}
}
