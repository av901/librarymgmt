package com.library.mgmt.librarymgmt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.librarymgmt.dto.BookDTO;
import com.library.mgmt.librarymgmt.entity.Book;
import com.library.mgmt.librarymgmt.repository.BookRepository;

@Service
public class BookManagementService {
	
	@Autowired
	BookRepository bookRepository;
	
	public BookDTO addBookEntityToTable(Book bookEntity) {
		Book savedBook = bookRepository.save(bookEntity);
		return savedBook.getBookDTO();
	}
	
	
	public List<BookDTO> getAllBooksByDepartmentId(Long deptId){
		List<Book> allBookInDept = bookRepository.findByDeptId(deptId);
		List<BookDTO> allBookDTOs = new ArrayList<BookDTO>();
		allBookInDept.stream().forEach(book -> {
			allBookDTOs.add(book.getBookDTO());
		});
		return allBookDTOs;
	}

}
