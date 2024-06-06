package com.ManirSaker.FirstJobApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Review extends AbstractEntity<Long> {

    @Column(name = "review_body", nullable = false, length = 500)
    private String body;

    @Column(name = "rating", nullable = false)
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}