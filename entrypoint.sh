#!/bin/bash

# Start ngrok in the background
nohup ngrok http 8080 &

# Wait for ngrok to initialize
sleep 5

# Fetch the ngrok URL
NGROK_URL=$(curl -s http://127.0.0.1:4040/api/tunnels | jq -r '.tunnels[0].public_url')

# Construct WebSocket URL
SIGNALING_SERVER_URL="ws://${NGROK_URL##*/}/signal"

# Export the URL to .env file
echo "SIGNALING_SERVER_URL=${SIGNALING_SERVER_URL}" > /usr/local/bin/.env

# Print the URL
echo "ngrok tunnel URL: ${SIGNALING_SERVER_URL}"

# Start the Redis server
redis-server /etc/redis/redis.conf

# Run the original command
exec "$@"
