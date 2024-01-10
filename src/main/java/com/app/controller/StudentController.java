package com.app.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping
	public List<Student> getAll(){
		
		List<Student> students = studentService.getAllStudents();
		
		return students;
	}
	
	
	@GetMapping("/{id}")
	public Student getByID(@PathVariable int id) {
		Student student =studentService.getStudentByID(id);
		
		return student;
	}
	
	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable int id) {
		studentService.deleteStudentBYID(id);
		
	}
	
	
	@PostMapping
	public Student saveNewStudent(@RequestBody Student s) {
		
		Student student= studentService.saveStudent(s);
		System.out.println(student);
		return student;
		
	
		
		
		
		
	}
	
	

}
