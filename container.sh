#!/usr/bin/env bash
TAG=dmsserv:latest
NAME=org
docker rm -f ${NAME} || true
docker run -d --name ${NAME} \
	-p 8080:8080 \
	-e DB_URL=jdbc:mysql://localhost:3310/dms \
	-e DB_USER=root \
	-e DB_PASS=password \
	${TAG}

