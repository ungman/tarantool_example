FROM tarantool/tarantool:2.11.0

CMD ["tarantool", "tt rocks install crud"]

COPY data/*.lua /opt/tarantool
COPY data/schema/*.lua /opt/tarantool/schema/

CMD ["tarantool", "/opt/tarantool/app.lua"]

