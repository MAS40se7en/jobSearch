package com.ManirSaker.FirstJobApp.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
//@Table(name = "jobs")
public class Job extends AbstractEntity<Long> {

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "min_salary", nullable = false)
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "located_at")
    private String location;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
}