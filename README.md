# Microservices Assignment
It covers Task1 and Task2 services

## Task1 Services
 - Greet Service - greet-service
   - This service calls the Hello Service and Log service to say Hello greeting to user
     - /greets/me
 - Hello Service - hello-service
   - Gets the hello word from service
     - /hello/say
 - Log Service - log-service
   - logs the payload and concats the name and surname
     - /log/concat
   

## Task2 Services
 - User Service - user-service
   - Saves user information
   - Gets list of subclasses
     - /users/save
     - /users/{id}
     - /users/parent/{id}
     - /users/list


## Start Services
First, start service-registry and cloud-gateway service
Next, Start all other user services and greet services

## Postman collections are attached

