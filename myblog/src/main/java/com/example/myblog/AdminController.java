package com.example.myblog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.example.myblog.entities.ResponseObj;

@Controller
@RequestMapping("/admin")
public class AdminController {

	PostRepository postRepository;

	@Autowired
	public AdminController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@GetMapping("/")
	public String postsPage(Model model) {

		List<Post> posts = new ArrayList<Post>();

		this.postRepository.findAll().forEach(i -> posts.add(i));

		model.addAttribute("posts", posts);

		return "posts";
	}

	@PostMapping(path = "/savepost", consumes = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody Post savePost(@RequestBody String body)  {

//		Thread.sleep(2000);

		Post post = new Post();
		post.setTitle("HTML POST");
		post.setContent(body);
		post.setSummary("Summary");
		post.setCreatedAt(new Date());
		postRepository.save(post);
		return post;
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
	
	@DeleteMapping(path = "/deletepost/{id}/")
	public ResponseEntity<?> deletePost(@PathVariable("id")  Long id) {
				
		this.postRepository.deleteById(id);
		
		ResponseObj apiResponse = new ResponseObj();

		apiResponse.setMessage("Post with ID: " + id + " has been deleted");
		apiResponse.setStatus(HttpStatus.OK.value());
		apiResponse.setTimeStamp(System.currentTimeMillis());

		
	    return new ResponseEntity<ResponseObj>(apiResponse, HttpStatus.OK);
	}


	@GetMapping("/fetchpost")
	public @ResponseBody Optional<Post> fetchPostbyId(@RequestParam("id") Long id) {
 
	   Optional<Post> post =    this.postRepository.findById(Long.valueOf(id)); 
	   this.postRepository.findById(Long.valueOf(id)); 
	   if(post.isPresent()) {
		   return post; 
	   }
		
	   return null;
	}

	/*
	 * @GetMapping("/") public String adminPage() { return "admin"; }
	 */

}
