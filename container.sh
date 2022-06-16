#!/usr/bin/env bash
if [[ -z "${D_TAG_VERSION}" ]]; then
	TAG=dmsserv:latest
else
	TAG=dmsserv:${D_TAG_VERSION}
fi
NAME=dmsrest
docker rm -f ${NAME} || true
docker run -d --name ${NAME} \
	-p 8080:8080 \
	-e DB_FULL_URL=jdbc:mysql://localhost:3310/dms \
	-e DB_USER=root \
	-e DB_PASS=password \
	${TAG}

