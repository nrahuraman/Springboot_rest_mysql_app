package com.example.demo.service;

import java.util.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Course;
import com.example.demo.repo.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService{

	//Autowire  injection
	@Autowired
	private CourseRepository courseRepo;
	
	
	
	@Override
	public String upsert(Course course) {
				
		courseRepo.save(course);//insert or update on PK
		check(course);
		return "success push";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepo.findById(cid);
		
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
		 
	}

	@Override
	public String deleteById(Integer id) {
		if(courseRepo.existsById(id))
		{
			courseRepo.deleteById(id);
			
		}
		else
		{
			return "No Record Found";
		}
		return "Deleted";
	}
	
	public void check(Course cs)
	{
		System.out.println("check"+cs.toString());
	}

}
