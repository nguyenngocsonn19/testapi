package com.example.testapi.dao;

import com.example.testapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e ORDER BY e.lastName ASC")
    List<Employee> findAllOrderByLastNameAsc();

    List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
