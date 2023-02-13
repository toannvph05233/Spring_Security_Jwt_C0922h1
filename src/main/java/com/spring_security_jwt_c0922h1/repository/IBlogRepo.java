package com.spring_security_jwt_c0922h1.repository;

import com.spring_security_jwt_c0922h1.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepo extends PagingAndSortingRepository<Blog, Integer> {
}
