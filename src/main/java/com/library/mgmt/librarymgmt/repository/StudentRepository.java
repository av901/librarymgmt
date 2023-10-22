package com.library.mgmt.librarymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.librarymgmt.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
