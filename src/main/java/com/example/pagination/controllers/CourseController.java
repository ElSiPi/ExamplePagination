package com.example.pagination.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pagination.models.Course;
import com.example.pagination.services.ICoursePaginationService;
import com.example.pagination.services.ICourseService;

@Controller
public class CourseController {

	@Autowired
	ICoursePaginationService coursePageServ;
	
	@Autowired
	ICourseService cService;

	@GetMapping("/course/{page}") // localhost:8080/course/
	public String getPaginatedCourses(Model model, @PathVariable(name = "page") int pageNumber) {
		int pageSize = 2;

		Page<Course> paginatedCourses = coursePageServ.getPaginatedCourses(pageNumber, pageSize, "title");
		List<Course> list = paginatedCourses.getContent();

		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", paginatedCourses.getTotalPages());
		model.addAttribute("totalItems", paginatedCourses.getTotalElements());
		model.addAttribute("courses", list);

		return "show-all-courses-paginated";
	}

	@GetMapping("/course/addNew") // localhost:8080/course/addNew
	public String getInsertNewCourse(Course course) {
		return "insert-new-course";
	}

	@PostMapping("/course/addNew")
	public String postInsertNewCourse(@Valid Course course, BindingResult result) {

		if (!result.hasErrors()) {
			cService.insertNewCourse(course);

			return "redirect:/course/showAll";
		} else {
			return "insert-new-course-page";
		}
	}
	
	@GetMapping("/course/showAll") // localhost:8080/course/showAll
	public String getShowAllCourses(Model model) {
		model.addAttribute("courses", cService.selectAllCourses());
		return "show-all-courses";
	}

}
