package com.example.pagination.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.pagination.models.Course;

public interface ICourseRepo extends CrudRepository<Course, Long> {

	ArrayList<Course> findAll();

	Course findByTitle(String title);

}
