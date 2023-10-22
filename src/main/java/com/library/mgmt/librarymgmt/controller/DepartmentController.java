package com.library.mgmt.librarymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.mgmt.librarymgmt.dto.DepartmentDTO;
import com.library.mgmt.librarymgmt.services.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/add")
	public DepartmentDTO addStudent(@Valid @RequestBody DepartmentDTO departmentDTO) {
		return departmentService.addDepartment(departmentDTO);
	}
	
	@GetMapping("/all")
	public List<DepartmentDTO> getAllDepartments(){
		return departmentService.getAllDepartment();
	}

}
