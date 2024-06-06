package com.ManirSaker.FirstJobApp.controller.web;

import com.ManirSaker.FirstJobApp.domain.Company;
import com.ManirSaker.FirstJobApp.domain.Job;
import com.ManirSaker.FirstJobApp.domain.dto.JobDTO;
import com.ManirSaker.FirstJobApp.repository.JobRepository;
import com.ManirSaker.FirstJobApp.service.CompanyService;
import com.ManirSaker.FirstJobApp.service.JobService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/jobs")
@Log4j2
public class JobController {

    @Autowired
    private final JobService jobService;

    @Autowired
    private final CompanyService companyService;

    private final JobRepository jobRepository;


    public JobController(JobRepository jobRepository, JobService jobService, CompanyService companyService) {
        this.jobService = jobService;
        this.companyService = companyService;
        this.jobRepository = jobRepository;
    }


    @GetMapping
    public String getAllJobs(Model model) {
        List<Job> jobs = this.jobService.findAll();
        model.addAttribute("job", jobs);
        return "jobs-list";
    }

    // adding the ability to access the job and the company classes
    @GetMapping("/add-job")
    public String addJob(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("companies", companyService.getAllCompanies());
        return "add-job";
    }

    // creating a new job using the input data read into the JobDTO
    // class and saving it into a new Job in from the Job class
    @PostMapping("/add-job")
    public String saveJob(@ModelAttribute JobDTO jobDto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add-job";
        }

        Job job = new Job();
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setLocation(jobDto.getLocation());
        job.setMinSalary(jobDto.getMinSalary());
        job.setMaxSalary(jobDto.getMaxSalary());

        Company company = companyService.getCompanyById(jobDto.getCompany().getId());
        job.setCompany(company);


        jobService.createJob(job);
        return "redirect:/jobs";
    }

    @GetMapping("/{id}/update")
    public String updateJob(Model model, @PathVariable Long id) {
        Job job = jobService.getJobById(id).orElseThrow();
        model.addAttribute("job", job);
        return "update-job";
    }

    // updating the job by getting the job data from
    // a JobService method using the job id and keeping
    // the company un-editable
    @PostMapping("/{id}/update")
    public String updateJob(
            Model model,
            @RequestParam Long id,
            @ModelAttribute("job") JobDTO jobDto,
            BindingResult bindingResult
    ) {
       if (bindingResult.hasErrors()) {
           return "update-job";
       }
       Job job = jobService.getJobById(id).orElseThrow();
       model.addAttribute("job", job);

       job.setId(jobDto.getId());
       job.setTitle(jobDto.getTitle());
       job.setDescription(jobDto.getDescription());
       job.setMaxSalary(jobDto.getMaxSalary());
       job.setMinSalary(jobDto.getMinSalary());
       job.setLocation(jobDto.getLocation());
       jobService.createJob(job);
       return "redirect:/jobs";
    }

    @GetMapping("/{id}")
    public String getJobById(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id).orElseThrow(
                () -> new RuntimeException(String.format("No Job found"))
        );
        model.addAttribute("job", job);
        return "job";

    }

    @GetMapping("/delete-job")
    public String deleteJob(@RequestParam Long id) {
        try {
            Job job = jobRepository.findById(id).get();

            jobRepository.delete(job);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return "redirect:/jobs";
    }
}