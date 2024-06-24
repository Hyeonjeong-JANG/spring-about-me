FROM redis

# Install ngrok and jq
RUN apt-get update && apt-get install -y curl jq && \
    curl -s https://ngrok-agent.s3.amazonaws.com/ngrok.asc | tee /etc/apt/trusted.gpg.d/ngrok.asc | apt-key add - && \
    echo "deb https://ngrok-agent.s3.amazonaws.com buster main" | tee /etc/apt/sources.list.d/ngrok.list && \
    apt-get update && apt-get install -y ngrok

COPY redis.conf /etc/redis/
COPY entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/entrypoint.sh
RUN chmod 777 /etc/redis/redis.conf

ENTRYPOINT ["entrypoint.sh"]
