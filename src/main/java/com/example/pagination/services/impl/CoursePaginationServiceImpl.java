package com.example.pagination.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pagination.models.Course;
import com.example.pagination.repos.ICoursePaginationRepo;
import com.example.pagination.services.ICoursePaginationService;


@Service
public class CoursePaginationServiceImpl implements ICoursePaginationService {

	@Autowired
	ICoursePaginationRepo coursePageRepo;
	

	@Override
	@Cacheable("courses")
	public Page<Course> getPaginatedCourses(int pageNumber, int pageSize, String title) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(title));
		return coursePageRepo.findAll(pageable);
	}
	
	
}
