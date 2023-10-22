package com.library.mgmt.librarymgmt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.librarymgmt.dto.DepartmentDTO;
import com.library.mgmt.librarymgmt.entity.Department;
import com.library.mgmt.librarymgmt.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
		Department dept = departmentDTO.getDepartmentEntity();
		Department savedDept = departmentRepository.save(dept);
		return savedDept.getDepartmentDTO();
	}
	
	public List<DepartmentDTO> getAllDepartment() {
		List<Department> deptList = departmentRepository.findAll();
		List<DepartmentDTO> deptDTOs = new ArrayList<DepartmentDTO>();
		deptList.stream().forEach(dept -> {
			DepartmentDTO deptDto = new DepartmentDTO();
			deptDto.setDeptName(dept.getDeptName());
		    deptDto.setId(dept.getId());
		    deptDTOs.add(deptDto);
		});
		return deptDTOs;
	}

}
