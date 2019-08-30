# Flight-API Consumer
Requirements
- 
1. docker
2. docker-compose

How to Run Consumer API?
-
1. deploy mongoDB
    > mongo
    
    > docker-compose up -d
2. export local env
    > export HOST_MONGO=localhost
    
    > export HOST_KAFKA=localhost
3. running consumer api
	> mvn clean install
	
	> java -jar target/consumer-1.0-SNAPSHOT.jar