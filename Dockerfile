FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/reward-program-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} reward-program.jar
ENTRYPOINT ["java","-jar","/reward-program.jar"]