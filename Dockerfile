FROM openjdk:17
EXPOSE 8080
USER root
COPY ./target/demo-${BUILD_NUMBER}.0-SNAPSHOT.jar /home/root/app.jar 
ENTRYPOINT ["java","-jar","/home/root/app.jar"]
