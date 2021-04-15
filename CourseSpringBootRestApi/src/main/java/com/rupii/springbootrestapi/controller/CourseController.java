package com.rupii.springbootrestapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rupii.springbootrestapi.dao.CourseRepository;
import com.rupii.springbootrestapi.dto.CourseDto;
import com.rupii.springbootrestapi.entities.Course;
import com.rupii.springbootrestapi.exception.ResourceNotFoundException;
import com.rupii.springbootrestapi.services.CourseService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ModelMapper modelMapper;

	// get all courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourse();
	}

	// get course by id
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourseById(@PathVariable String courseId) {
		return courseService.getCourseById(Long.parseLong(courseId));
	}

	// add course
	@PostMapping(value = "/courses")
	public Course addCourses(@RequestBody CourseDto courseDto) {
		Course course =modelMapper.map(courseDto,Course.class);
		return this.courseService.addCourse(course);
	}

	// update courses
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody CourseDto courseDto) {
		Course course =modelMapper.map(courseDto,Course.class);
		return this.courseService.updateCourse(course);
	}

	// delete course by id
	@DeleteMapping("/course/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long courseId)
			throws ResourceNotFoundException {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + courseId));

		courseRepository.delete(course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}