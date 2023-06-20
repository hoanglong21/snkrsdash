FROM tomcat:latest
LABEL maintainer="Workflowbox"

# Copy the war file to the Tomcat webapps directory
COPY dist/BigProject_wDB.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat when the container launches
CMD ["catalina.sh", "run"]
