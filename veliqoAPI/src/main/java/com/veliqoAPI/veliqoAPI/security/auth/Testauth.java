package com.veliqoAPI.veliqoAPI.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Testauth {
    @GetMapping("/admin/test")
    public String adminTest(){
        return " Admin Authenticated";
    }

    @GetMapping("/applicant/test")
    public String applicantTest(){
        return " Applicant Authenticated";
    }

    @GetMapping("/auth/test")
    public String openTest(){
        return  "Open request allowed";
    }
}
