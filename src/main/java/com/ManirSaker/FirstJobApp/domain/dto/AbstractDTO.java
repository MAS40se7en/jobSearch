package com.ManirSaker.FirstJobApp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@SuperBuilder
public class AbstractDTO<Long> {

    private Long id;
    private LocalDateTime updated;
    private LocalDateTime created;
}
