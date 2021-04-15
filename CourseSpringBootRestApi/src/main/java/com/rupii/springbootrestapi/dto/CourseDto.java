package com.rupii.springbootrestapi.dto;

public class CourseDto {

	private long courseId;
	private String title;
	private String discription;

	public CourseDto(){
		
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

	public CourseDto(long courseId, String title, String discription) {
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
