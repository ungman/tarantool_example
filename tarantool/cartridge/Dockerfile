FROM centos:7
ARG TARANTOOL_VERSION=2.8
ARG TARANTOOL_SERVER_USER="root"
ARG TARANTOOL_SERVER_UID=0
ARG TARANTOOL_SERVER_GROUP="root"
ARG TARANTOOL_SERVER_GID=0
ARG TARANTOOL_WORKDIR="/app"
ARG TARANTOOL_RUNDIR="/tmp/run"
ARG TARANTOOL_DATADIR="/tmp/data"
ARG TARANTOOL_INSTANCES_FILE="./instances.yml"
ENV TARANTOOL_WORKDIR=$TARANTOOL_WORKDIR
ENV TARANTOOL_RUNDIR=$TARANTOOL_RUNDIR
ENV TARANTOOL_DATADIR=$TARANTOOL_DATADIR
ENV TARANTOOL_INSTANCES_FILE=$TARANTOOL_INSTANCES_FILE

#Commгnity version
RUN curl -L https://tarantool.io/installer.sh | VER=$TARANTOOL_VERSION /bin/bash -s -- --repo-only && \
    yum -y install cmake make gcc gcc-c++ git unzip tarantool tarantool-devel cartridge-cli && \
    yum clean all

COPY data /app

RUN groupadd -g $TARANTOOL_SERVER_GID $TARANTOOL_SERVER_GROUP && \
    useradd -u $TARANTOOL_SERVER_UID -g $TARANTOOL_SERVER_GID -m -s /bin/bash $TARANTOOL_SERVER_USER \
    || true
USER $TARANTOOL_SERVER_USER:$TARANTOOL_SERVER_GROUP

WORKDIR $TARANTOOL_WORKDIR
CMD cartridge version
EXPOSE 8081 3301
ENTRYPOINT ["sh", "entrypoint.sh"]