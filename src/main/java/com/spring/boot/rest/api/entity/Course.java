package com.spring.boot.rest.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    private Long courseId;
    private String courseName;
    private String description;

}
