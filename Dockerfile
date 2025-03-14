FROM maven:3.9.9-eclipse-temurin-21

# Оновлення apt і встановлення необхідних пакетів
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    gnupg \
    unzip \
    git \
    xvfb \
    libx11-xcb1 \
    libxcomposite1 \
    libxcursor1 \
    libxdamage1 \
    libxi6 \
    libxtst6 \
    libnss3 \
    libnspr4 \
    libxrandr2 \
    libxss1 \
    libatk1.0-0 \
    libatk-bridge2.0-0 \
    libgtk-3-0 \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*

# Завантаження та встановлення Google Chrome
RUN wget -q -O chrome-linux64.zip https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.88/linux64/chrome-linux64.zip \
    && unzip chrome-linux64.zip \
    && rm chrome-linux64.zip \
    && mv chrome-linux64 /opt/chrome/ \
    && ln -s /opt/chrome/chrome /usr/local/bin/

# Завантаження та встановлення ChromeDriver

RUN wget -q -O chromedriver-linux64.zip https://bit.ly/chromedriver-linux64-121-0-6167-85 && \
    unzip -j chromedriver-linux64.zip chromedriver-linux64/chromedriver && \
    rm chromedriver-linux64.zip && \
    mv chromedriver /usr/local/bin/

RUN wget https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.88/linux64/chromedriver-linux64.zip \
    && unzip -j chromedriver-linux64.zip chromedriver-linux64/chromedriver \
    && rm chromedriver-linux64.zip \
    && mv chromedriver /usr/local/bin/


# Клонування репозиторію з тестами
RUN git clone https://github.com/Ant198/formSubmissionTest.git /app

WORKDIR /app

ENV DISPLAY=:99

# Запуск тестів з використанням Xvfb для віртуального дисплею
CMD ["bash", "-c", "Xvfb :99 -ac & export DISPLAY=:99 && mvn clean test"]
