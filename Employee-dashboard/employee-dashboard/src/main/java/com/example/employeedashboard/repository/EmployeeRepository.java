package com.example.employeedashboard.repository;

import com.example.employeedashboard.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Optional<Employee> findByEname(String ename);
}
