package com.example.myblog;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myblog.data.PostRepository;
import com.example.myblog.entities.Post;

@SpringBootApplication
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}
	
	
	  @Bean public CommandLineRunner dataLoader(PostRepository post) { return new
	  CommandLineRunner() {
	  
	  @Override public void run(String... args) throws Exception { 
		  
		  
	  post.save(new
	        Post("Jawad Featured Post", new Date(),
	             "This is wider card with supporting text below as a natural lead-in to additional content"
	             , "This is wider card ",true,false));
	  
	  post.save(new
		        Post("Post title", new Date(),
		             "This is wider card with supporting text below as a natural lead-in to additional content"
		             , "Second wider card ",true,false));
	  
	  
	  post.save(new
		        Post("Build Blog Step By Step Yohoo!!!", new Date(),
		             "You will learn how to build blog based on Spring Boot Step By Step, Bootstrap and Thymeleaf is used for frontend"
		             , "You will learn how to build blog based on Spring Boot Step By Step, Bootstrap and Thymeleaf is used for frontend ",false,true));
	  
	  
	  post.save(new
		        Post("Sample blog post 1", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));
	  post.save(new
		        Post("Sample blog post 2", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));

	  post.save(new
		        Post("Sample blog post 3", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));

	  post.save(new
		        Post("Sample blog post 4", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));

	  
	  
	  post.save(new
		        Post("Sample blog post 5", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));


	  post.save(new
		        Post("Sample blog post 6", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));


	  post.save(new
		        Post("Sample blog post 7", new Date(),
		             "Cum sociis natoque penatibus et magnis nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum."
		             , "This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.",false,false));

	  
	  } }; }
	 

}
