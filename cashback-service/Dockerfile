FROM openjdk:11-jdk-alpine
COPY ./build/libs/*.jar cashback-service.jar
EXPOSE 8003
ENTRYPOINT ["java","-jar","cashback-service.jar"]