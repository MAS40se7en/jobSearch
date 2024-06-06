package com.ManirSaker.FirstJobApp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class CeoDTO extends AbstractDTO<Long> {

    private String name;
    private String note;
}
