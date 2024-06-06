package com.ManirSaker.FirstJobApp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Ceo extends AbstractEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "note")
    private String note;

    @OneToOne
    @JoinColumn(name = "company")
    private Company company;
}
