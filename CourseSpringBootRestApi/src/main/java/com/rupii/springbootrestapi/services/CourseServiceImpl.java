package com.rupii.springbootrestapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rupii.springbootrestapi.dao.CourseRepository;
import com.rupii.springbootrestapi.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	@Override
	public Optional<Course> getCourseById(long courseId) {
		return courseRepository.findByCourseId(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

}
