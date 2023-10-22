package com.library.mgmt.librarymgmt.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.mgmt.librarymgmt.entity.Department;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DepartmentDTO {
	
	@NotNull
	@NotEmpty
	@JsonAlias({"dept_name"})
	String deptName;
	
	Long id;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Department getDepartmentEntity() {
		Department dept = new Department();
		dept.setDeptName(deptName);
		dept.setId(id);
		return dept;
	}

}
