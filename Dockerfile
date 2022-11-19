FROM openjdk:11
COPY ./build/libs/grupo02-0.0.1-SNAPSHOT.jar venta.jar
ENTRYPOINT ["java", "-jar", "venta.jar"]