# Use the official OpenJDK image as base
FROM openjdk:11

# Set the working directory in the container
WORKDIR usr/app/

# Copy the packaged jar file into the container
COPY target/product_query_service-application.jar usr/app/product_query_service_application.jar

#work directory
WORKDIR /usr/app

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "product_query_service-application.jar"]
