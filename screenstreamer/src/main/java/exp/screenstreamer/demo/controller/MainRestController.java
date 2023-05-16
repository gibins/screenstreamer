package exp.screenstreamer.demo.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

@RestController
@ComponentScan
public class MainRestController {
	
	@CrossOrigin
	@PostMapping("/t")
	public String  getTestResponse(HttpServletRequest httpServletRequest,Model model) throws Exception {
		System.out.println("Successful");
		System.setProperty("java.awt.headless", "false"); 
		Robot r = new Robot();
		Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage Image = r.createScreenCapture(capture);
		File a =null;
		a = new File("a");
		ImageIO.write(Image, "jpg", a);
		System.out.println("Screenshot saved");
		
		byte[] fileContent = FileUtils.readFileToByteArray(a);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		System.out.println(encodedString);
		 
		return encodedString;
	}
	
	@GetMapping("/t")
	public String getError() {
		System.out.println("Successfull");
		return "successfull";
	}

}
