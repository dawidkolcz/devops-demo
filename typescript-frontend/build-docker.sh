#!/bin/bash

if [[ $PWD == *"spring-frontend" ]]; then
  DIRECTORY="$PWD"
else
  DIRECTORY="$PWD/spring-frontend/"
fi

DOCKER_BUILDKIT=1 docker build --tag devops-demo:frontend $DIRECTORY
