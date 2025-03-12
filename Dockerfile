FROM ubuntu:22.04

RUN apt-get update && apt-get install -y \
    wget \
    curl \
    gnupg \
    unzip \
    openjdk-21-jdk \
    maven

RUN wget -qO- https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg && \
        echo "deb [signed-by=/usr/share/keyrings/google-chrome.gpg] http://dl.google.com/linux/chrome/deb/ stable main" | tee /etc/apt/sources.list.d/google-chrome.list > /dev/null && \
        apt-get update && apt-get install -y google-chrome-stable && rm -rf /var/lib/apt/lists/* \

RUN CHROME_VERSION=$(google-chrome --version | awk '{print $3}') && \
        wget -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE)/chromedriver_linux64.zip && \
        unzip /tmp/chromedriver.zip -d /usr/local/bin/ && \
        chmod +x /usr/local/bin/chromedriver && \
        rm -rf /tmp/chromedriver.zip


WORKDIR /app

COPY . .

CMD ["mvn", "clean", "test"]