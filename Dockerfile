#  step 1 : User an official openJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# step 2: Set the working directory inside the container
WORKDIR /app

# step 3 copy you jar file to the container
ARG JAR_FILE=target/deployment_test-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Step 4 : Expose the port you spring boot will run on
EXPOSE 8080

# Step 5 : Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]