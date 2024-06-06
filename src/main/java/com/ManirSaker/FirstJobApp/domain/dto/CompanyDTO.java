package com.ManirSaker.FirstJobApp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class CompanyDTO extends AbstractDTO<Long> {
    private String name;
    private String description;
    private List<JobDTO> jobs;
    private List<ReviewDTO> reviews;
    private CeoDTO ceo;
}
