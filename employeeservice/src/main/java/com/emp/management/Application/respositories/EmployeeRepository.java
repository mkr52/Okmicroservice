package com.emp.management.Application.respositories;

import com.emp.management.Application.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
