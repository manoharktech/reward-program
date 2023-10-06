# reward-program
retail reward-program to provide points to customers

The rest API to get customer rewards based on customerNumber
# http://localhost:8080/customers/101/rewards

Using actuator,check the application is UP.
http://localhost:8080/actuator/health
refer the document (retail-rewards.docx)/retail-rewards.pdf

Disable security features for actuator
management.security.enabled = false

Created a Dockerfile and add the configurations for containerizing the app
Build a Spring Boot Docker image

Make sure you have Docker Engine installed. To check it, run the docker ps or docker info command on the terminal screen

Run your Docker Engine
docker build -t reward-program:spring-docker 

Run the docker image ls command to check if the image exists. You should be able to see your image in the repository. 

like repository, tag, image ID , created and size.

Run the Spring Boot Docker image in a container

docker run -p 8080:8080 reward-program:spring-docker.

un the curl -v localhost:8080/api/hello command in your terminal to test

this is how we containerize.

These images, we store as artifacts in Nexus repository.
these images will be retrive by container for deploying the services.


A retailer offers a rewards program to its customers awarding points based on each recorded
purchase as follows:
 
For every dollar spent over $50 on the transaction, the customer receives one point.
In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points

The package name is structured as com.charter.reward
H2 in-memory database to store the information.
Added the db script in script.sql

Custom Exception is thrown, if customer number not found.

Added the h2 dependency for in memory database.



