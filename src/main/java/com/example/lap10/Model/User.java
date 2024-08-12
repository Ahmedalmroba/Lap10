package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null ")
    @NotEmpty
    @Size(min = 4)
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Name must contain only characters")
    private String name;
    @NotEmpty(message = "must not be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique ")
    private String email;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(20) not null  ")
    private String password;
    @Column(columnDefinition = "int not null  ")
    @NotNull(message ="must not be empty" )
    @Min(22)
    private int age;


    private String role;
}