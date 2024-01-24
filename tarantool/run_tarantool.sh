#!/bin/bash
docker rm -f tarantool-one-node
docker rmi tarantool-tarantool-one-node
docker stop tarantool-cartridge

docker  compose up --build --detach