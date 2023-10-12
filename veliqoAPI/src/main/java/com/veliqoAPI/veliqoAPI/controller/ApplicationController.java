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

    @PostMapping("/applicant/apply")
    public Application appli(@Validated @RequestBody Application application) throws Exception {
         return applicationService.apply(application);
    }

    // all applications
    @GetMapping("/admin/listApplications")
    public List<Application> lst() throws Exception {
        return applicationService.list();
    }

    @GetMapping("/admin/list")
    public List<Application> lsting() throws Exception {
        String status = "Pending";
        return applicationService.listbyStatus(status);
    }

    // logged in applicant
    @GetMapping("/applicant/application/{email}")
    public List<Application> profile(@PathVariable String email) throws Exception {
        return applicationService.applicant(email);
    }
    // approve application
    @PutMapping("/admin/approve/{id}")
    public String approving(@PathVariable Long id) throws Exception {
       return applicationService.approve(id);
    }
    //delete application
    @DeleteMapping("/admin/delete/{id}")
    public  String delete(@PathVariable Long id) throws Exception {
        return applicationService.deleteAppl(id);
    }

    //reject application
    @PutMapping("/admin/reject/{id}")
    public String rejecting(@PathVariable Long id) throws Exception {
        return applicationService.reject(id);
    }

    // get application by status
    @GetMapping("/admin/status/{status}")
    public List<Application> list(@PathVariable String status) throws Exception {
        return applicationService.listbyStatus(status);
    }
}
