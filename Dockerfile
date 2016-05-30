FROM java:8
VOLUME /tmp
ADD target/Triangle-0.0.1.war
RUN bash -c 'touch target/Test-0.0.1.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/target/Test-0.0.1.war"]