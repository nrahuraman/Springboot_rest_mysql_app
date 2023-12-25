package com.example.demo.service;

import java.util.List;

import com.example.demo.binding.Course;

public interface CourseService {

	//insertions and update
	public String upsert(Course course);
	
	//
	public Course getById(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer id);
}
