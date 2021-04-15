package com.rupii.springbootrestapi.services;

import java.util.List;
import java.util.Optional;

import com.rupii.springbootrestapi.entities.Course;

public interface CourseService {

	public List<Course> getAllCourse();

	public Optional<Course> getCourseById(long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

}
