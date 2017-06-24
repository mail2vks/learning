Sample project to learn docker-compose

1. Building java project

> ./gradlew clean build

2. Build docker containers and start 

> docker-compose up --build -d

3. Open http://localhost:8080

4. To shutdown docker containers

> docker-compose down -v