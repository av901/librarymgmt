package com.library.mgmt.librarymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.librarymgmt.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
