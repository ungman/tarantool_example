#!/bin/bash
docker rm -f tarantool-cartridge
docker rmi tarantool-tarantool-cartridge
docker stop tarantool-one-node

docker  compose up --build --detach