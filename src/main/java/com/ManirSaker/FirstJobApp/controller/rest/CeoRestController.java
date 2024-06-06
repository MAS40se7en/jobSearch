package com.ManirSaker.FirstJobApp.controller.rest;

import com.ManirSaker.FirstJobApp.domain.Ceo;
import com.ManirSaker.FirstJobApp.service.CeoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company/{companyId}")
public class CeoRestController {

    private final CeoService ceoService;

    public CeoRestController(CeoService ceoService) {
        this.ceoService = ceoService;
    }

    // getting a CEO of a company based on the company's id
    @GetMapping("/ceo")
    public ResponseEntity<Ceo> getCeo(@PathVariable Long companyId) {
        return new ResponseEntity<>(ceoService.getCeoById(companyId), HttpStatus.OK);
    }

    @PostMapping("/ceo")
    public ResponseEntity<String> addCeo(@RequestBody Ceo ceo, @PathVariable Long companyId) {
        boolean added = ceoService.addCeo(ceo, companyId);
        if (added) {
            ceoService.addCeo(ceo, companyId);
            return new ResponseEntity<>("Ceo added successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ceo not added",HttpStatus.NOT_FOUND);
        }
    }
}