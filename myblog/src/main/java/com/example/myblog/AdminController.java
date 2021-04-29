package com.example.myblog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@PostMapping(path = "/savepost", consumes = MediaType.TEXT_HTML_VALUE)
	public String savePost(@RequestBody String body)  {

//		Thread.sleep(2000);

		Post post = new Post();
		post.setTitle("HTML POST");
		post.setContent(body);
		post.setSummary("Summary");
		post.setCreatedAt(new Date());
		postRepository.save(post);
		return "posts";
	}
	
	@PatchMapping(path = "/editpost/{id}/", consumes = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody Post editPost(@PathVariable("id")  Long id,@RequestBody String body) {
		 
		
		 Optional<Post> record = this.postRepository.findById(Long.valueOf(id));
		 this.postRepository.findById(Long.valueOf(id)); if(record.isPresent()) {
		 
			 if(body != null && !body.isEmpty()) { 
				 Post post = record.get(); 
				 post.setContent(body); 
				 return this.postRepository.save(post); 
				 
			  }
		  
		  }
		 
		  
		  return null;
		 
		
	}

	/*
	 * @GetMapping("/fetchpost/{id}") public @ResponseBody Optional<Post>
	 * fetchPostbyId(@RequestParam("id") Long id String id) {
	 * 
	 * Optional<Post> post = null; //Optional<Post> post =
	 * this.postRepository.findById(Long.valueOf(id)); if(post.isPresent()) { return
	 * post; }
	 * 
	 * return null; }
	 * 
	 * 
	 */
	@GetMapping("/fetchpost")
	public @ResponseBody Optional<Post> fetchPostbyId(@RequestParam("id") Long id) {
 
	   Optional<Post> post =    this.postRepository.findById(Long.valueOf(id)); 
	   this.postRepository.findById(Long.valueOf(id)); 
	   if(post.isPresent()) {
		   return post; 
	   }
		
	   return null;
	}

	@GetMapping("/")
	public String adminPage() {
		return "admin";
	}

}
