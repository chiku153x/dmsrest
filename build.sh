#!/usr/bin/env bash

TAG=chiku153/dmsrest:v.018
#TAG=synchrorkkk/dmsrest:v.014

docker buildx build  --platform=linux/amd64,linux/arm64 -t ${TAG}  ${tag} --push .

