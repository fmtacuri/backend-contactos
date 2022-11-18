FROM openjdk:11
COPY . /contactos
WORKDIR /contactos
COPY ./build/libs/grupo02-0.0.1-SNAPSHOT.jar persona.jar
ENTRYPOINT ["java", "-jar", "persona.jar"]