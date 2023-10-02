package com.cgi.springrest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cgi.springrest.model.Blog;
import com.cgi.springrest.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {

	@Autowired
	BlogService blogService;

	@GetMapping()
	public ResponseEntity<List<Blog>> getAllBlogs() {

		List<Blog> blogs = blogService.getAllBlogs();
		return new ResponseEntity<>(blogs, HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		Blog savedBlog = blogService.saveBlog(blog);
		return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
	}

	@PutMapping("/{blogId}")
	public ResponseEntity<Blog> updateBlog(@PathVariable int blogId, @RequestBody Blog updatedBlog) {

		Blog updated = blogService.updateBlog(blogId, updatedBlog);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{blogId}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable int blogId) {

		Blog deletedBlog = blogService.deleteBlog(blogId);
		if (deletedBlog != null) {
			return new ResponseEntity<>(deletedBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
