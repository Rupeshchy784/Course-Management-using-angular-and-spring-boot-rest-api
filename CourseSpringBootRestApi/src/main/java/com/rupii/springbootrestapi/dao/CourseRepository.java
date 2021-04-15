package com.rupii.springbootrestapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rupii.springbootrestapi.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findByCourseId(long courseId);
	
}
