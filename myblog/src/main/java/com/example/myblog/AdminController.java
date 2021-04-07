package com.example.myblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@GetMapping("/posts")
	public String postsPage() {
		return "posts";
	}
	
	@GetMapping("/")
	public String adminPage() {
		return "admin";
	}
	
}
