package com.example.pagination.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagination.models.Course;
import com.example.pagination.repos.ICourseRepo;
import com.example.pagination.services.ICourseService;


@Service
public class CourseServiceImpl implements ICourseService{
	
	@Autowired
	ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Course> selectAllCourses() {
		return (ArrayList<Course>) courseRepo.findAll();
	}

	@Override
	public Course insertNewCourse(Course course) {

		Course c = courseRepo.findByTitle(course.getTitle());

		if (c != null) {
			c.setTitle(course.getTitle());
			c.setCreditPoints(course.getCreditPoints());
			c.setProfessor(course.getProfessor());
			courseRepo.save(c);
			return c;
		} else {
			Course cNew = new Course(course.getTitle(), course.getCreditPoints(), course.getProfessor());
			courseRepo.save(cNew);
			return cNew;
		}
	}

}
