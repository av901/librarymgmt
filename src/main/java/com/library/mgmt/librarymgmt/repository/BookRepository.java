package com.library.mgmt.librarymgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.librarymgmt.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
   
	public List<Book> findByDeptId(Long deptId);
	
}
