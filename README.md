# Build
mvn clean package && docker build -t rayno.javaee/javaee-helloworld .

# RUN

docker rm -f javaee-helloworld || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaee-helloworld rayno.javaee/javaee-helloworld 