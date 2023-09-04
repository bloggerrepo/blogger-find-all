package com.htc.blogger.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.blogger.entity.Blog;
import com.htc.blogger.repo.BlogRepository;

@RestController
@RequestMapping("/api")
public class BlogController {

	@Autowired
	BlogRepository blogRepository;

	@GetMapping("/blogs")
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	@PostMapping("/blog")
	public Blog createBlog(@RequestBody Blog blog) {
		if (blog.getCreatedAt() == null)
			blog.setCreatedAt(LocalDateTime.now());
		return blogRepository.save(blog);
	}

	

}
