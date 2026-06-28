# Use Tomcat base image
FROM tomcat:9.0-jdk11

# Copy WAR file from Maven target folder into Tomcat webapps
COPY target/ecommerce-app-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ecommerce-app-1.0-SNAPSHOT.war

# Expose port
EXPOSE -p 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

