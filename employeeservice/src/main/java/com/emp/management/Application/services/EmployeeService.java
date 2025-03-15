package com.emp.management.Application.services;

import com.emp.management.Application.dto.EmployeeDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDTO> getAll();
    public EmployeeDTO getById(String id);
    public EmployeeDTO save(EmployeeDTO employee);
    public EmployeeDTO update(EmployeeDTO employeeDTO);
    public EmployeeDTO delete(String id);
    public Page<EmployeeDTO> findPagination(int pageSize, int pageNumber, String sortField, String sortDirection);
}
