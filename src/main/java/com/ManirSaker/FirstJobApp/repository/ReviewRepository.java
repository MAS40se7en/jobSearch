package com.ManirSaker.FirstJobApp.repository;

import com.ManirSaker.FirstJobApp.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    // listing a list of reviews using the company's id
    List<Review> findByCompanyId(Long companyId);
}