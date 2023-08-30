FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/File.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]