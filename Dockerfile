FROM openjdk:11
MAINTAINER solutionlab.ee
COPY build/libs/Invoicer-1.0.0.jar invoicer-1.0.0.jar
ENTRYPOINT ["java","-jar","/invoicer-1.0.0.jar"]