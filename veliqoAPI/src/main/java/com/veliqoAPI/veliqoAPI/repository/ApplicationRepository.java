package com.veliqoAPI.veliqoAPI.repository;

import com.veliqoAPI.veliqoAPI.model.Application;
import com.veliqoAPI.veliqoAPI.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
         List<Application> findByApplicant(User user);
}
