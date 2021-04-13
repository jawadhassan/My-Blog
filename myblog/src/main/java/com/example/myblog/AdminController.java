package com.example.myblog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String postsPage(Model model) {
		
		List<Post> posts = new ArrayList<Post>(); 
		
		this.postRepository.findAll().forEach(i -> posts.add(i));
		
		model.addAttribute("posts", posts);
		
		return "posts";
	}
	
	@PostMapping(path="/savepost", consumes = MediaType.TEXT_HTML_VALUE)
	public String savePost(@RequestBody String body) throws InterruptedException {
		
//		Thread.sleep(2000);
		
		Post post = new Post();
		post.setTitle("HTML POST");
		post.setContent(body);
		post.setSummary("Summary");
		post.setCreatedAt(new Date());
		postRepository.save(post);
		return "posts";
	}
	
	@GetMapping("/")
	public String adminPage() {
		return "admin";
	}
	
}
