package com.emp.management.Application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String job;

    private int age;

    private Date addedDate;
}
