package com.cgi.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cgi.springrest.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
	

}
