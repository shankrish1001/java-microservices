Spring Boot Microservices refers to the development of microservice-based applications using the Java Spring Boot framework. 

This approach involves building a larger system as a collection of small, independent, and loosely coupled services, each focusing on a specific business capability.

zipkin:
docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin

Monitoring:
Run Prometheus as Docker image.
Run Grafana as Docker image.
docker-compose up -d

http://localhost:8081/api/v1/department
http://localhost:8765/api/v1/department

http://localhost:8082/api/v1/employee
http://localhost:8765/api/v1/employee

Service-registry:
http://localhost:8761/

API GateWay:
http://localhost:8765/



