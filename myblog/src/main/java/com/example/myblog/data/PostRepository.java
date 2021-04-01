package com.example.myblog.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.myblog.entities.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
	
	List<Post> isFeaturedIsTrue();
	
	Optional<Post> isBannerIsTrue();
	
	Page<Post> findByIsFeaturedAndIsBanner(boolean condition, boolean condition1, Pageable pageable);
	

}
