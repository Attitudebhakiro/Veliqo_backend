# Back End
Is a REST API build with:
* java 
* Spring boot
* Maven
* Spring Data JPA
* Spring Security

# Front End
Is build with Angular and bootstrap

# Database
The API uses MySQL Database
Database name: veliqo_challenge_ab
credentials of the database are:
* Username: root
* Password: password

## Damn data
Included in this project is database sql with some test data
Admin credentials :
* Email: attitude@veliqo.com
* password: Password

Applicants
* Email: palmet@veliqo.com
* password: Password

* Email: happie@veliqo.com
* password: Password

# How it works
## Registration
* The registration page automatically gives new user APPLICANT rights
* ADMIN rights can be given through backend for security reasons
* Full Names and Emails do not repeat
* ID numbers accepts only Numbers letters and -
* Middle name is optional

## Login
* ADMIN is directed to home page where he/she can approve and delete APPLICANT's Insurance applications
* APPLICANT is directed to home where he/she can apply for insurance

## Reports
ADMIN can see all applications previously done in the system
APPLICANT can only see the progr and/status of his/her insurance application