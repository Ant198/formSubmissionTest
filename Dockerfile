FROM maven:3.9.9-eclipse-temurin-21

# Завантаження та встановлення Google Chrome
# RUN wget -q -O chrome-linux64.zip https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.88/linux64/chrome-linux64.zip \
    # && unzip chrome-linux64.zip \
    # && rm chrome-linux64.zip \
    # && mv chrome-linux64 /opt/chrome/ \
    # && ln -s /opt/chrome/chrome /usr/local/bin/

# Клонування репозиторію з тестами
RUN git clone https://github.com/Ant198/formSubmissionTest.git /app

WORKDIR /app

COPY . .

RUN mvn clean test -DskipTests

CMD ["mvn", "clean", "teest", "-DskipTests"]
