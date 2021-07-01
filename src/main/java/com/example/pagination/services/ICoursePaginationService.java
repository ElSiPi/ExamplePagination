package com.example.pagination.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICoursePaginationService {
	
	//for pagination
	//List<Course> findAllByTitle(String title, Pageable pageable);
	
	Page<com.example.pagination.models.Course> getPaginatedCourses(int pageNumber, int pageSize, String title);


}
