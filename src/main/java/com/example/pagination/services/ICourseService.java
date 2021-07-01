package com.example.pagination.services;

import java.util.ArrayList;

import com.example.pagination.models.Course;


public interface ICourseService {

	
	ArrayList<Course> selectAllCourses();
	
	Course insertNewCourse(Course course);
}
