package tn.esprit.microservice;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseRestAPI {

	private CourseService courseService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		return new ResponseEntity<>(courseService.addCourse(course),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Course> getCourses() {
		return courseService.getCourses();
	}
	 
	@PutMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> updateCourse(@PathVariable(value ="id")int id, @RequestBody Course course) {
		return new ResponseEntity<>(courseService.updateCourse(course, id),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCourse(@PathVariable(value ="id")int id) {
		return new ResponseEntity<>(courseService.deleteCourse(id),HttpStatus.OK);
	}
}
