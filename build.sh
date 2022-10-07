#!/usr/bin/env bash

TAG=chiku153/dmsrest:v.010
#TAG=synchrorkkk/dmsrest:v.003

docker buildx build --no-cache --platform=linux/amd64,linux/arm64 -t ${TAG}  ${tag} --push .