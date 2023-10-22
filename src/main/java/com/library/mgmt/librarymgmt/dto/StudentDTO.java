package com.library.mgmt.librarymgmt.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.mgmt.librarymgmt.entity.Department;
import com.library.mgmt.librarymgmt.entity.Student;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {
	
	Long id;
	
	@NotEmpty
	@NotNull
	String name;
	
	@JsonAlias({"dept_name", "deptName"})
	String deptName;
	
	@JsonAlias("dept_id")
	Long deptId;
	
	@NotNull
	@JsonAlias({"roll_number"})
	String rollNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", deptName=" + deptName + ", rollNumber=" + rollNumber + "]";
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Student getStudentEntity() {
		Department dept = new Department();
		dept.setId(deptId);
		dept.setDeptName(deptName);
		Student student = new Student();
		student.setDept(dept);
		student.setName(name);
		student.setRollNumber(rollNumber);
		student.setId(id);
		return student;
	}

}
