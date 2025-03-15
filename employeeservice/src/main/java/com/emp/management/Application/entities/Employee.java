package com.emp.management.Application.entities;

import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String id;

    @NotEmpty
    @NotBlank
    private String name;
    private String surname;

    @Size(min = 10, max = 50)
    @Email
    @Pattern(regexp = "[a-zA-Z0-9]")
    private String email;
    private String job;
    @Min(18)
    @Max(100)
    @PositiveOrZero
    private int age;
    @Future
    @Past
    private Date addedDate;
}
