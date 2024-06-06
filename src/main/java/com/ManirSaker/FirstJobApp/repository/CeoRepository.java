package com.ManirSaker.FirstJobApp.repository;

import com.ManirSaker.FirstJobApp.domain.Ceo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeoRepository extends JpaRepository<Ceo, Long> {
    // getting the ceo using the company's id
    Ceo findByCompanyId(Long companyId);
}
