package com.example.myblog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.myblog.data.PostRepository;
import com.example.myblog.entities.Post;

@Controller
public class HomeController {
	
	PostRepository postRepository;
	
	@Autowired
	public HomeController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}


	@GetMapping("/")
	public String home(Model model) {
		List<Post> cards = new ArrayList<Post>();
		List<Post> posts = new ArrayList<Post>();
		
//	    postRepository.findAll().forEach(i -> posts.add(i));
		postRepository.isFeaturedIsTrue().forEach(i -> cards.add(i));
		model.addAttribute("cards",cards);
		
		if(postRepository.isBannerIsTrue().isPresent()) {
			Post banner = postRepository.isBannerIsTrue().get();
			model.addAttribute("banner",banner);
		}
		
		Pageable page = PageRequest.of(
		            0, 3, Sort.by("createdAt").descending());
		postRepository.findByIsFeaturedAndIsBanner(false,false, page).forEach(i -> posts.add(i));
		
		model.addAttribute("posts",posts);
		
		
		return "home";
	}
}
