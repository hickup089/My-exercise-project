package com.lx.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@RequestMapping("hello")
	@ResponseBody
	public String test() {
		return "hello world";
	}
	
}
