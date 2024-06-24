#!/bin/bash

# Start ngrok in the background
nohup ngrok http 8443 &

# Wait for ngrok to initialize
sleep 10  # ngrok 초기화 시간

# Print the ngrok URL
curl -s http://127.0.0.1:4040/api/tunnels | jq -r '.tunnels[0].public_url'

# Start the Redis server
redis-server /path/to/redis.conf

# Run the original command
exec "$@"
