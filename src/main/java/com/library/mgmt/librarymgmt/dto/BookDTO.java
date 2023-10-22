package com.library.mgmt.librarymgmt.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.mgmt.librarymgmt.entity.Book;
import com.library.mgmt.librarymgmt.entity.Department;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BookDTO {

	Long id;
	
	@NotEmpty(message = "Book Name should not be empty")
	@NotNull(message = "Book Name should not be null")
	@JsonAlias({"bookName", "book_name"})
	private String bookName;
	
	@NotNull(message = "Department Id should not be null")
	@JsonAlias({"deptId", "dept_id"})
	private Long deptId;
	
	@NotNull(message = "Department Name should not be null")
	@JsonAlias({"deptName", "dept_name"})
	private String deptName;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
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
	public Book getBookEntity(){
		Book book = new Book();
		Department dept = new Department();
		dept.setId(deptId);
		dept.setDeptName(deptName);
		book.setBookName(bookName);
		book.setDept(dept);
		book.setId(id);
		return book;
	}
	@Override
	public String toString() {
		return "BookDTO [bookName=" + bookName + ", deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
