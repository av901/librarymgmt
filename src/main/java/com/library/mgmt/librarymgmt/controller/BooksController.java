package com.library.mgmt.librarymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.mgmt.librarymgmt.dto.BookDTO;
import com.library.mgmt.librarymgmt.entity.Book;
import com.library.mgmt.librarymgmt.services.BookManagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private BookManagementService bookMgmtService;
	
	@PostMapping("/add")
	public BookDTO addBooks(@Valid @RequestBody BookDTO bookDto) {
		Book book = bookDto.getBookEntity();
		return bookMgmtService.addBookEntityToTable(book);
	}
	
	@GetMapping("/all/{deptId}")
	public List<BookDTO> getAllBooksByDepartmentId(@Valid @PathVariable("deptId") Long deptId){
		return bookMgmtService.getAllBooksByDepartmentId(deptId);
	}

}
