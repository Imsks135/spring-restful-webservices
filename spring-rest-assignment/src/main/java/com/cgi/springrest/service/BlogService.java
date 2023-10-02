package com.cgi.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.springrest.model.Blog;
import com.cgi.springrest.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;

	// Save a Blog and Return Blog Object
	public Blog saveBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	// Fetch All Blogs and Return All Blogs
	public List<Blog> getAllBlogs() {

		return blogRepository.findAll();
	}

	// Delete a Blog and Return Deleted Blog
	public Blog deleteBlog(int blogId) {
		Blog blog = blogRepository.findById(blogId).orElse(null);
		if (blog != null) {
			blogRepository.delete(blog);
		}
		return blog;
	}

	// Update a Blog and Return Updated Blog
	public Blog updateBlog(int blogId, Blog updatedBlog) {
		Blog blog = blogRepository.findById(blogId).orElse(null);
		if (blog != null) {
			
			blog.setBlogTitle(updatedBlog.getBlogTitle());
			blog.setAuthorName(updatedBlog.getAuthorName());
			blog.setBlogContent(updatedBlog.getBlogContent());
			return blogRepository.save(blog);
		}
		return null;
	}
}
