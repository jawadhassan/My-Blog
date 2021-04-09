package com.example.myblog;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myblog.data.PostRepository;
import com.example.myblog.entities.Post;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	PostRepository postRepository;
	
	
	@Autowired
	public AdminController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@GetMapping("/posts")
	public String postsPage() {
		return "posts";
	}
	
	@PostMapping(path="/savepost", consumes = MediaType.TEXT_HTML_VALUE)
	public boolean savePost(@RequestBody String body) throws InterruptedException {
		
		Thread.sleep(2000);
		
		Post post = new Post();
		post.setTitle("HTML POST");
		post.setContent(body);
		post.setSummary("Summary");
		post.setCreatedAt(new Date());
		postRepository.save(post);
		return true;
	}
	
	@GetMapping("/")
	public String adminPage() {
		return "admin";
	}
	
}
