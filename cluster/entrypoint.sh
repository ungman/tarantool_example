#!/usr/bin/env bash
set -e
echo "$PWD"

cd /app
echo "Building application"
cartridge build
echo "Start cartridge cluster in background"
cartridge start --run-dir=/tmp/run --data-dir=/tmp/data -d

echo "Setup topology"
cartridge replicasets setup --bootstrap-vshard --run-dir /tmp/run

echo "Run migrations"
curl -X POST http://localhost:8081/migrations/up
#echo "Loading data"
#tarantool /entrypoint/load_data.lua
echo "require('data')" | tarantoolctl connect admin:secret-cluster-cookie@0.0.0.0:3301

echo "Restarting cluster"
cartridge stop --run-dir=/tmp/run

cartridge start --run-dir=/tmp/run --data-dir=/tmp/data
