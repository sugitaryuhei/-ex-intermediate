package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/abc")
public class AbcController {
	
	@RequestMapping("")
	public String index() {
		return "index";
	}

}
