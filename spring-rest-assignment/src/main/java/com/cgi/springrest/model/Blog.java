package com.cgi.springrest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogId;
	private String blogTitle;
	private String authorName;
	@Column(length = 1000)
	private String blogContent;

	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Blog(int blogId, String blogTitle, String authorName, String blogContent) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.authorName = authorName;
		this.blogContent = blogContent;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", authorName=" + authorName + ", blogContent="
				+ blogContent + "]";
	}

}
