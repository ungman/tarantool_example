FROM tarantool/tarantool:2.11.0

CMD ["tarantool", "tt rocks install crud"]

COPY *.lua /opt/tarantool
COPY schema/*.lua /opt/tarantool/schema/

CMD ["tarantool", "/opt/tarantool/app.lua"]

