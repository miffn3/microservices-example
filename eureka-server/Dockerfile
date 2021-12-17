FROM openjdk:11-jdk-alpine
COPY ./build/libs/*.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-server.jar"]