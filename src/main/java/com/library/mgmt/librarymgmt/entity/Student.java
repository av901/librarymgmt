package com.library.mgmt.librarymgmt.entity;

import com.library.mgmt.librarymgmt.dto.StudentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student", schema = "lms")
public class Student {
	
	@Id
	@Column(name ="id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "name", nullable = false)
	String name;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", nullable=false)
	Department dept;
	
	@Column(name = "roll_number", nullable = false, unique = true)
	String rollNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public StudentDTO getStudentDTO(){
		StudentDTO student = new StudentDTO();
		student.setName(name);
		student.setDeptId(dept.getId());
		student.setId(id);
		student.setDeptName(dept.getDeptName());
		return student;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + ", rollNumber=" + rollNumber + "]";
	}

}
