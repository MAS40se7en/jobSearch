package com.ManirSaker.FirstJobApp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class JobDTO extends AbstractDTO<Long> {
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private CompanyDTO company;
}
