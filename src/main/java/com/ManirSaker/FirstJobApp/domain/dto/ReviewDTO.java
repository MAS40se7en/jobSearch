package com.ManirSaker.FirstJobApp.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class ReviewDTO extends AbstractDTO<Long> {
    private String body;
    private double rating;
    private CompanyDTO company;
}
