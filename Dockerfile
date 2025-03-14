FROM maven:3.9.9-openjdk-21-slim

# Оновлення apt і встановлення необхідних пакетів
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    gnupg \
    unzip \
    git \
    xvfb \
    && rm -rf /var/lib/apt/lists/*

# Завантаження та встановлення Google Chrome
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && dpkg -i google-chrome-stable_current_amd64.deb || apt-get install -fy \
    && rm -f google-chrome-stable_current_amd64.deb

# Завантаження та встановлення ChromeDriver
RUN wget -O /tmp/chromedriver.zip https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.88/linux64/chromedriver-linux64.zip \
    && unzip /tmp/chromedriver.zip -d /tmp/ \
    && mv /tmp/chromedriver-linux64/chromedriver /usr/local/bin/chromedriver \
    && chmod +x /usr/local/bin/chromedriver \
    && rm -rf /tmp/chromedriver.zip /tmp/chromedriver-linux64

# Клонування репозиторію з тестами
RUN git clone https://github.com/Ant198/formSubmissionTest.git /app

WORKDIR /app

# Запуск тестів з використанням Xvfb для віртуального дисплею
CMD ["bash", "-c", "Xvfb :99 -ac & export DISPLAY=:99 && mvn clean test"]
