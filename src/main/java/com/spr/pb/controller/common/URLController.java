package com.spr.pb.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLController {
	
	
	@GetMapping("/views/**")
	public String views(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.replace("/views","");
	}
	
	
}
