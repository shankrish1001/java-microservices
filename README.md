Spring Boot Microservices refers to the development of microservice-based applications using the Java Spring Boot framework. 

This approach involves building a larger system as a collection of small, independent, and loosely coupled services, each focusing on a specific business capability.

//zipkin:
//implementation 'io.micrometer:micrometer-tracing-bridge-brave'
//implementation 'io.zipkin.reporter2:zipkin-reporter-brave'
//docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin

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

Run Prometheus (Docker)
docker run -d \
-p 9090:9090 \
-v /path/to/prometheus.yml:/etc/prometheus/prometheus.yml \
--name prometheus \
prom/prometheus

Run Grafana (Docker)
docker run -d -p 3000:3000 --name=grafana grafana/grafana

http://localhost:3000
user:admin
pass:admin
