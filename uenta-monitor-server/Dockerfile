# Version 1.0.0
FROM java:8

MAINTAINER nin "nin@XXXXXXX.com"

# ENV WORK_PATH /home/nin/docker
# ENV APP_NAME @project.build.finalName@.@project.packaging@
# ENV APP_VERSION @project.version@

EXPOSE 7030 7039

# USER
#USER user:group

# VOLUME
#VOLUME ["/home/nin", "/tmp/data"]
VOLUME /tmp

# ADD
ADD ./target/uenta-monitor-server.jar /app.jar

# COPY
#COPY $APP_NAME $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
#WORKDIR $WORK_PATH

RUN bash -c 'touch /app.jar'

# ENTRYPOINT 
ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app.jar"]

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
#CMD ["-jar", "@project.build.finalName@.@project.packaging@"]
