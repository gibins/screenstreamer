package exp.screenstreamer.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/home")
	public String getHome() {
		System.out.println("HOME");
		return "index";
		
	}

}
