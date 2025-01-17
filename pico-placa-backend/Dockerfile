FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/pico-placa-backend-0.0.1-SNAPSHOT.jar picoplacabackend.jar
EXPOSE 3000
#ENTRYPOINT exec java $JAVA_OPTS -jar picoplacabackend.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar picoplacabackend.jar
