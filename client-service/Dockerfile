FROM openjdk:11-jdk-alpine
COPY ./build/libs/*.jar client-service.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","client-service.jar"]