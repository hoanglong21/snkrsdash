# Use an official Tomcat image as a parent image
FROM tomcat:8.5.73-jdk8-openjdk

# Remove the default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file into the container at the Tomcat webapps directory
COPY dist/BigProject_wDB.war /usr/local/tomcat/webapps/snkrsdash.war

# Copy the contents of /usr/local/tomcat/webapps.dist into /usr/local/tomcat/webapps
RUN cp -R /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/

# Expose the port that Tomcat will run on
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]