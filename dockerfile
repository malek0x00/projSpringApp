# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

COPY ./wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh

# Copy the packaged JAR file into the container at the specified path
COPY target/projSpringApp-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that the application will run on
EXPOSE 8081

# Specify the command to run on container startup
CMD ["java", "-jar", "app.jar", "--server.port=8081"]

CMD ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "app.jar", "--server.port=8081"]
