# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11

# Add Maintainer Info
LABEL maintainer="luizhenrique.se@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/kafka-poc-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} kafkapoc.jar

# Run the jar file
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","/kafkapoc.jar"]