package com.library.mgmt.librarymgmt.entity;

import java.util.List;

import com.library.mgmt.librarymgmt.dto.DepartmentDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department", schema = "lms")
public class Department {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "dept_name", nullable = false, unique = true)
	String deptName;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Student> students;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Student> getStudents() {
		System.out.println("GET STUDENTS CALLED");
		return students;
	}

	public void setStudents(List<Student> students) {
		System.out.println("SET STUDENTS CALLED");
		this.students = students;
	}
	
	public List<Book> getBooks() {
		System.out.println("GET BOOKS CALLED");
		return books;
	}

	public void setBooks(List<Book> books) {
		System.out.println("SET BOOKS CALLED");
		this.books = books;
	}

	public DepartmentDTO getDepartmentDTO(){
		DepartmentDTO department = new DepartmentDTO();
		department.setId(id);
		department.setDeptName(deptName);
		return department;
	}
	
}
