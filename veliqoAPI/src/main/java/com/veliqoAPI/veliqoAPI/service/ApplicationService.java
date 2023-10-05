package com.veliqoAPI.veliqoAPI.service;

import com.veliqoAPI.veliqoAPI.model.Application;
import com.veliqoAPI.veliqoAPI.repository.ApplicationRepository;
import com.veliqoAPI.veliqoAPI.security.user.User;
import com.veliqoAPI.veliqoAPI.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;
 // insurance application
    public Application apply(Application application) throws Exception {
        try {
            return applicationRepository.save(application);

        }catch (Exception ex){
            throw new Exception("Application Fail: "+ex.getMessage());

        }
    }
   // list all applicants
    public List<Application> list() throws Exception {
        try {
            return applicationRepository.findAll();

        }catch (Exception ex){
            throw new Exception("Application Fail: "+ex.getMessage());

        }

    }

    //get the logged in applicant's application
    public List<Application> applicant(String email) throws Exception {
        try {
            if(userRepository.existsByEmail(email)){
                User user = userRepository.findByEmail(email).get();
            return applicationRepository.findByApplicant(user);
            }
         return null;
        } catch (Exception ex) {
            throw new Exception("Application Fail: " + ex.getMessage());

        }
    }

        //approve application
        public String approve(Long id) throws Exception {

        try{
            if(applicationRepository.existsById(id)){
                Application existingAppl = applicationRepository.findById(id).get();
                existingAppl.setApplicationStatus("Approved");
                applicationRepository.save(existingAppl);
                return "Application approved";

            }else {
                return "Id not found";
            }

        }catch (Exception ex){
            throw new Exception("Approval Failed: " + ex.getMessage());
        }


        }

        // delete application
      public  String deleteAppl(Long id) throws Exception {
          try{
              if(applicationRepository.existsById(id)){
                  applicationRepository.deleteById(id);
                  return "Application deleted";

              }else {
                  return "Id not found";
              }

          }catch (Exception ex){
              throw new Exception("Approval Failed: " + ex.getMessage());
          }
      }


}
