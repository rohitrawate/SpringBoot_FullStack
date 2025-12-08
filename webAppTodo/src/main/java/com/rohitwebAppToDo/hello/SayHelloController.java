package com.rohitwebAppToDo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	
	@RequestMapping("say-hello")
	@ResponseBody    // Without this Spring will try look for `view` to return
	public String sayHello() {
		
		return "Hello, form the `SayHelloConstructor`";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody    // Without this Spring will try look for `view` to return
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h2>My first html with body</h2>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
