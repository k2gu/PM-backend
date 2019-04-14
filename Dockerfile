FROM gradle:jdk8

ENV HOME=/home/gradle

USER gradle

# Prepare source directories
RUN mkdir -p $HOME/app
COPY . $HOME/app
WORKDIR $HOME/app

# Build the project
RUN gradle build

# Run the service
ENTRYPOINT ["java"]
CMD ["-jar", "build/libs/gs-rest-service-0.1.0.jar"]

EXPOSE 8080
