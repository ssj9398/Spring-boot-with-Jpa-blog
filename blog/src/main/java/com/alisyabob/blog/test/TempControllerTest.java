package com.alisyabob.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	@GetMapping("temp/home")
	public String tempHome() {
		System.out.println("home.htl");
		return "/home.html";
	}
	@GetMapping("temp/img")
	public String tempImg() {
		System.out.println("imgtest");
		return "/a.png";
	}
	
	@GetMapping("temp/jsp")
	public String tempJsp() {
		System.out.println("jsptest");
		return "/test";
	}
}
