package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(10) not null  ")
    @Size(min = 4)
    private String title;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(15) not null  ")

    private String description;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(20) not null  ")
    private String location;

    @NotNull(message = "must not be empty")
    @Column(columnDefinition = "int not null  ")
    @Positive
    private int salary;
    private int postingDate;
}