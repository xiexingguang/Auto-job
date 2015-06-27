package com.ec.autojob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usr")
public class UserController {
	
	@RequestMapping("/test")
	public void save(){
		System.out.println("just test");
	}

}
