#!/usr/bin/env bash

TAG=chiku153/dmsrest:v.014
#TAG=synchrorkkk/dmsrest:v.014

docker buildx build --no-cache --platform=linux/amd64,linux/arm64 -t ${TAG}  ${tag} --push .