package com.rupii.springbootrestapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(length = 40)
	private long courseId;
	@Column(length = 40)
	private String title;
	@Column(length = 40)
	private String discription;

	public Course() {

	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Course(long courseId, String title, String discription) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", discription=" + discription + "]";
	}
}
