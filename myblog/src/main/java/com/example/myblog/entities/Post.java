package com.example.myblog.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;




@Entity
@Table(name = "Post")
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;

	private String title;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User author;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category categories;

	private Date createdAt;

	@Column(columnDefinition="TEXT")
	private String content;

	private String summary;
	
	private boolean isFeatured;
	
	private boolean isBanner;
	
	
	
	
	public Post(String title, Date createdAt, String content, String summary, boolean isFeatured, boolean isBanner) {
		this.title = title;
		this.createdAt = createdAt;
		this.content = content;
		this.summary = summary;
		this.isFeatured = isFeatured;
		this.isBanner = isBanner;
	}

	public Post(Long id, String title, Date createdAt, String content, String summary, boolean isFeatured,
			boolean isBanner) {
		this.id = id;
		this.title = title;
		this.createdAt = createdAt;
		this.content = content;
		this.summary = summary;
		this.isFeatured = isFeatured;
		this.isBanner = isBanner;
	}

	
	
	public Post() {
	}

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public boolean isFeatured() {
		return isFeatured;
	}

	public void setFeatured(boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

	public boolean isBanner() {
		return isBanner;
	}

	public void setBanner(boolean isBanner) {
		this.isBanner = isBanner;
	}

	public Post(Long id, String title, User author, Category categories, Date createdAt, String content, String summary,
			boolean isFeatured, boolean isBanner) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.categories = categories;
		this.createdAt = createdAt;
		this.content = content;
		this.summary = summary;
		this.isFeatured = isFeatured;
		this.isBanner = isBanner;
	}
	
	public Post(String title, User author, Category categories, Date createdAt, String content, String summary,
			boolean isFeatured, boolean isBanner) {
		this.title = title;
		this.author = author;
		this.categories = categories;
		this.createdAt = createdAt;
		this.content = content;
		this.summary = summary;
		this.isFeatured = isFeatured;
		this.isBanner = isBanner;
	}

}
