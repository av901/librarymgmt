package com.library.mgmt.librarymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.mgmt.librarymgmt.dto.StudentDTO;
import com.library.mgmt.librarymgmt.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/add")
	public StudentDTO addStudent(@Valid @RequestBody StudentDTO studentDto) {
		return studentService.addStudent(studentDto);
	}
	
	@GetMapping("/all")
	public List<StudentDTO> getAllStudent(){
		return studentService.getAllStudent();
	}

}
