FROM openjdk:11-jdk-alpine
COPY ./build/libs/*.jar payment-service.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","payment-service.jar"]