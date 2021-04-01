package com.example.myblog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String home(HttpServletRequest request, Model model) {

		int page = 0; // default page number is 0
		//TODO:Make the size of the page dynamic if possible
		int size = 3; // default page size is 3

		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		List<Post> cards = new ArrayList<Post>();
		
		postRepository.isFeaturedIsTrue().forEach(i -> cards.add(i));
		
		model.addAttribute("cards", cards);

		if (postRepository.isBannerIsTrue().isPresent()) {
			Post banner = postRepository.isBannerIsTrue().get();
		
			model.addAttribute("banner", banner);
		}

		Pageable pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());

		model.addAttribute("paginationPosts", postRepository.findByIsFeaturedAndIsBanner(false, false, pageRequest));

		return "home";
	}
}
