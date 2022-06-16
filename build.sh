#!/usr/bin/env bash
if [[ -z "${D_TAG_VERSION}" ]]; then
	TAG=dmsserv:latest
else
	TAG=dmsserv:${D_TAG_VERSION}
fi
docker build -t ${TAG} .
