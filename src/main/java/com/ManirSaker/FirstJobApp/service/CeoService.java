package com.ManirSaker.FirstJobApp.service;

import com.ManirSaker.FirstJobApp.domain.Ceo;
import com.ManirSaker.FirstJobApp.domain.Company;
import com.ManirSaker.FirstJobApp.repository.CeoRepository;
import org.springframework.stereotype.Service;

@Service
public class CeoService {

    private final CeoRepository ceoRepository;
    private final CompanyService companyService;

    public CeoService(CeoRepository ceoRepository, CompanyService companyService) {
        this.ceoRepository = ceoRepository;
        this.companyService = companyService;
    }

    public Ceo getCeoById(Long companyId) {
        return ceoRepository.findByCompanyId(companyId);
    }

    public boolean addCeo(Ceo ceo, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            ceo.setCompany(company);
            ceoRepository.save(ceo);
            return true;
        }
        return false;
    }
}
