FROM tomee:8-jre17-plume
COPY target/jakartaee-hello-world.war /usr/local/tomee/webapps/
