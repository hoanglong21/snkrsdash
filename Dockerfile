FROM tomcat:latest
LABEL maintainer="Workflowbox"

# Copy the WAR file into the container at the Tomcat webapps directory
COPY dist/BigProject_wDB.war /usr/local/tomcat/webapps/snkrsdash.war

# Copy the contents of /usr/local/tomcat/webapps.dist into /usr/local/tomcat/webapps
RUN cp -R /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat when the container launches
CMD ["catalina.sh", "run"]
