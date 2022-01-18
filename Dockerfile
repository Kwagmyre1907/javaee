FROM airhacks/glassfish
COPY ./target/javaee-helloworld.war ${DEPLOYMENT_DIR}
