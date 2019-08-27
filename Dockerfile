FROM maven:3.6.1-jdk-8

WORKDIR /home/appuser/consumer

COPY . ./
RUN mvn clean install

WORKDIR /home/appuser/consumer-app
RUN cp /home/appuser/consumer/target/consumer-1.0-SNAPSHOT.jar .

RUN ls -la

RUN pwd

CMD java -jar consumer-1.0-SNAPSHOT.jar


