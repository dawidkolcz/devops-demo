#!/bin/bash

if [[ $PWD == *"spring-backend" ]]; then
  DIRECTORY="$PWD"
else
  DIRECTORY="$PWD/spring-backend/"
fi

DOCKER_BUILDKIT=1 docker build --tag devops-demo:backend $DIRECTORY
