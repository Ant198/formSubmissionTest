FROM maven:3.9.9-eclipse-temurin-21

RUN git clone https://github.com/Ant198/formSubmissionTest.git /app

WORKDIR /app

RUN mvn clean test -DskipTests

CMD ["mvn", "clean", "test"]
