package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.Course;
import com.example.demo.service.CourseService;
import com.fasterxml.jackson.annotation.JsonInclude;

@RestController
public class CourseRestController {

	@Autowired
	private CourseService courseService;
	
	Course cs=new Course();
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course)
	{
		System.out.println(course.toString());
		String status=courseService.upsert(course);
		
		return new ResponseEntity<>(status,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid)
	{
		Course course= courseService.getById(cid);
		
		return new ResponseEntity<>(course,HttpStatus.OK);
		
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		List<Course> allCourse=courseService.getAllCourses();
		return new ResponseEntity<>(allCourse,HttpStatus.OK); 
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course)
	{
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id)
	{
		String status=courseService.deleteById(id);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	
	
	
}
