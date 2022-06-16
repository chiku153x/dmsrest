#!/bin/bash
export CURRENT_DIR=`pwd`
export D_TAG_VERSION=poc_v1
echo ${CURRENT_DIR}
cd ${CURRENT_DIR}/../dmsrest && sh ./build.sh
cd ${CURRENT_DIR}/../dmswebui && sh ./build.sh
docker images
docker tag dmsserv:${D_TAG_VERSION} chiku153/dmsrest:${D_TAG_VERSION}
docker push chiku153/dmsrest:${D_TAG_VERSION}
docker tag dmswebui:${D_TAG_VERSION} chiku153/dmsui:${D_TAG_VERSION}
docker push chiku153/dmsui:${D_TAG_VERSION}