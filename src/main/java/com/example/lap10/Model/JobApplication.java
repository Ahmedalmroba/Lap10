package com.example.lap10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(20) not null  ")
    private int userId;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(20) not null  ")
    private int jobPostId;
}