package com.devon.hourglassapi.repository;

import com.devon.hourglassapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
