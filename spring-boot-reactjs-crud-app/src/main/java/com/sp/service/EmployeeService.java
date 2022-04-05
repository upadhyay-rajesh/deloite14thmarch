package com.sp.service;

import java.util.List;
import java.util.Optional;

import com.sp.model.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    void delete(Employee employee);
}
