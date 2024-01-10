package com.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.model.Student;
import com.app.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	
	
	public List<Student> getAllStudents() {
		
		List<Student> student = studentRepo.findAll();
		
		return student;
		
	}
	
	
	public Student getStudentByID(int id) {
		Student student =studentRepo.findById(id).orElse(null);
		
		return student;
	}
	
	
	public void deleteStudentBYID(int id) {
	studentRepo.deleteById(id);
	System.out.println("succesfully deleted");
		
		
	}
	
	public Student saveStudent( Student s) {
		
		Student student= studentRepo.save(s);
		
		return student;
		
	}
	
	
	public Student updateStudent(Student s) {
		if(studentRepo.existsById(s.getID())) {
			
			return studentRepo.save(s);	
			
		}
		else {
			return null;
		}
		
	}
	
	
}
