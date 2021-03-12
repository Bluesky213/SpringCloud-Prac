FROM java:8
ADD ./target/demo-0.0.1.jar app.jar
ENTRYPOINT java -jar ${JAVA_OPTS} app.jar
