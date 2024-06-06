package com.ManirSaker.FirstJobApp.controller.rest;

import com.ManirSaker.FirstJobApp.domain.Review;
import com.ManirSaker.FirstJobApp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company/{companyId}")
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // getting all the reviews of a company based on the company's id
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Long companyId) {
        boolean added = reviewService.addReview(review, companyId);
        if (added) {
            reviewService.addReview(review, companyId);
            return new ResponseEntity<>("Review added successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not added",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean updated = reviewService.updateReview(review, companyId, reviewId);
        if (updated) {
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean deleted = reviewService.deleteReview(companyId, reviewId);
        if (deleted) {
            return new ResponseEntity<>("Review deleted",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not deleted",HttpStatus.NOT_FOUND);
        }
    }
}