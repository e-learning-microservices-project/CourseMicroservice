package tn.esprit.microservice;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
	
	@Autowired
	private CourseRepository CourseRepository;
	
	public Course addCourse(Course c) {
		return CourseRepository.save(c);
	}
	
	public Course updateCourse(Course c, int id) {
		if (CourseRepository.findById(id).isPresent())
		{
			Course course = CourseRepository.findById(id).get();
			//subject,description,language
			course.setSubject(c.getSubject());
			course.setDescription(c.getDescription());
			course.setLanguage(c.getLanguage());
			course.setTeacher_id(c.getTeacher_id());
			
			return CourseRepository.save(course);
		}
		else return null;	
	}
	public String deleteCourse (int id)
	{
		if (CourseRepository.findById(id).isPresent())
		{
			CourseRepository.deleteById(id);
			return "Course deleted!";
		}return "Course not found!";
	}
	
	
	public List<Course> getCourses ()
	{
		return CourseRepository.findAll();
	}

}
