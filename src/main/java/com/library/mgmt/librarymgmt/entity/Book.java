package com.library.mgmt.librarymgmt.entity;

import com.library.mgmt.librarymgmt.dto.BookDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book", schema = "lms")
public class Book {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "book_name", nullable = false)
	String bookName;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", nullable = false)
	Department dept;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public BookDTO getBookDTO(){
		BookDTO book = new BookDTO();
		book.setBookName(bookName);
		book.setDeptId(dept.getId());
		book.setId(id);
		book.setDeptName(dept.getDeptName());
		return book;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", dept=" + dept + "]";
	}
	
}
