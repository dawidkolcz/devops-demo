#!/bin/bash
if [[ $PWD == *"jenkins" ]]; then
  DIRECTORY="$PWD"
else
  DIRECTORY="$PWD/jenkins/"
fi

DOCKER_BUILDKIT=1 docker build --tag devops-demo:jenkins $DIRECTORY
