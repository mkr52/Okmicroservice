package com.emp.management.Application.controllers;

import com.emp.management.Application.dto.EmployeeDTO;
import com.emp.management.Application.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<EmployeeDTO>(employeeService.save(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(id);
        return new ResponseEntity<EmployeeDTO>(employeeService.update(employeeDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> delete(@PathVariable("id") String id) {
        return new ResponseEntity<EmployeeDTO>(employeeService.delete(id), HttpStatus.OK);
    }
}
