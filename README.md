# AREP microservice proxy implementation

This is a partial when we have to implement a microservces architecture 

![architecture image](imgs/architecture.png)

So the idea is having a three EC2 instances, two instances working as math services and one EC2-Proxy service which is going to handle the browser petitions and balancing using a balancing algorithm the petitions given a case that any of all the instances are not working. 


# AWS Deployment

First, we need to create 3 EC2 instances with free tier features, each of them must have a custom tcp inboundaring rule that allows the 8080 port. 

- Mathservice 1
![math-service creation instance](imgs/math-service-1.png)

- Mathservice 2

- Proxy