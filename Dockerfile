FROM ubuntu:22.04
ENV DISPLAY=:99
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    gnupg \
    unzip \
    openjdk-21-jdk \
    maven \
    xvfb \
    && rm -rf /var/lib/apt/lists/*
RUN wget -qO- https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg && \
        echo "deb [signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" | tee /etc/apt/sources.list.d/google-chrome.list > /dev/null && \
        apt-get update && apt-get install -y google-chrome-stable && rm -rf /var/lib/apt/lists/* \

RUN wget -O /tmp/chromedriver.zip https://storage.googleapis.com/chrome-for-testing-public/134.0.6998.88/linux64/chromedriver-linux64.zip \
    && unzip /tmp/chromedriver.zip -d /tmp/ \
    && mv /tmp/chromedriver-linux64/chromedriver /usr/local/bin/chromedriver \
    && chmod +x /usr/local/bin/chromedriver \
    && rm -rf /tmp/*
WORKDIR /app
COPY . .
CMD ["sh", "-c", "Xvfb :99 -screen 0 1920x1080x24 & mvn clean test"]