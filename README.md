#workshop-microservice-spring-boot-prometheus-grafana
![alt text](https://miro.medium.com/max/1730/1*v5Mztgozw5fKcvkJbBdsgg.png)



# How to run
./gradlew bootRun

# how to run prometheus
docker compose -f docker/prometheus/docker-compose.yaml up

# how to run grafana
docker compose -f docker/grafana/docker-compose.yaml up
