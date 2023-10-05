package com.veliqoAPI.veliqoAPI.controller;

import com.veliqoAPI.veliqoAPI.model.Application;
import com.veliqoAPI.veliqoAPI.security.user.User;
import com.veliqoAPI.veliqoAPI.service.ApplicationService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/api/applicant/apply")
    public Application appli(@Validated @RequestBody Application application) throws Exception {
         return applicationService.apply(application);
    }

    // all applications
    @GetMapping("/api/admin/listApplications")
    public List<Application> lst() throws Exception {
        return applicationService.list();
    }

    // logged in applicant
    @GetMapping("/api/applicant/application/{email}")
    public List<Application> profile(@PathVariable String email) throws Exception {
        return applicationService.applicant(email);
    }
    // approve
    @PutMapping("/api/admin/approve/{id}")
    public String approving(@PathVariable Long id) throws Exception {
       return applicationService.approve(id);
    }
    @DeleteMapping("/api/admin/delete/{id}")
    public  String delete(@PathVariable Long id) throws Exception {
        return applicationService.deleteAppl(id);
    }
}
