package com.emp.management.Application.services;

import com.emp.management.Application.dto.EmployeeDTO;
import com.emp.management.Application.entities.Employee;
import com.emp.management.Application.respositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    private final ModelMapper modelMapper;

    // Same as RequiredArgsConstructor annotation
//    public EmployeeServiceImpl(EmployeeRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees=repository.findAll();
        List<EmployeeDTO> list=employees.stream().map(employee -> modelMapper.map(employee,EmployeeDTO.class))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public EmployeeDTO getById(String id) {
        Employee employee=repository.findById(id).orElseThrow(()->new IllegalArgumentException());
        EmployeeDTO employeeDTO=modelMapper.map(employee,EmployeeDTO.class);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        // Using model mapper
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEntity = repository.save(employee);
        EmployeeDTO savedEmployee = modelMapper.map(savedEntity, EmployeeDTO.class);
//        Employee entity = new Employee();
//        entity.setId(employee.getId());
//        entity.setName(employee.getName());
//        entity.setSurname(employee.getSurname());
//        entity.setEmail(employee.getEmail());
//        entity.setJob(employee.getJob());
//        entity.setAge(employee.getAge());
//        entity.setAddedDate(employee.getAddedDate());

//        Employee savedEntity = repository.save(entity);

//        EmployeeDTO savedEmployee = new EmployeeDTO();
//        savedEmployee.setId(savedEntity.getId());
//        savedEmployee.setName(savedEntity.getName());
//        savedEmployee.setAddedDate(savedEntity.getAddedDate());

        return  savedEmployee;
    }

    @Override
    public EmployeeDTO delete(String Id) {

        Employee employee =repository.findById(Id).orElseThrow(()->new IllegalArgumentException());
        EmployeeDTO employeeDTO=modelMapper.map(employee,EmployeeDTO.class);
        // employeeRepository.deleteById(Id);
        repository.delete(employee);
        //delete all
//        employeeRepository.deleteAll();
        return employeeDTO;
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {

        Employee employee = repository.findById(employeeDTO.getId()).orElseThrow(IllegalArgumentException::new);
        employee.setName(employeeDTO.getName());
        employee.setJob(employeeDTO.getJob());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAge(employeeDTO.getAge());
        employee.setSurname(employeeDTO.getSurname());
        repository.save(employee);
        return employeeDTO;
    }

    @Override
    public Page<EmployeeDTO> findPagination(int pageSize, int pageNumber, String sortField, String sortDirection) {
        return null;
    }
}
