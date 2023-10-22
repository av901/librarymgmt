package com.library.mgmt.librarymgmt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.librarymgmt.dto.StudentDTO;
import com.library.mgmt.librarymgmt.entity.Student;
import com.library.mgmt.librarymgmt.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public StudentDTO addStudent(StudentDTO StudentDTO) {
		Student student = StudentDTO.getStudentEntity();
		Student savedStudent = studentRepository.save(student);
		return savedStudent.getStudentDTO();
	}
	
	public List<StudentDTO> getAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		studentList.stream().forEach(student -> {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setDeptName(student.getDept().getDeptName());
			studentDTO.setName(student.getName());
			studentDTO.setRollNumber(student.getRollNumber());
			studentDTO.setDeptId(student.getDept().getId());
		    studentDTOs.add(studentDTO);
		});
		return studentDTOs;
	}

}
