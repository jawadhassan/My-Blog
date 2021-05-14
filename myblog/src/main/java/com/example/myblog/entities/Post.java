package com.example.myblog.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "Post")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;


	private String title;

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

}
