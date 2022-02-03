#!/bin/bash
if [[ $PWD == *"jenkins" ]]; then
  DIRECTORY="$PWD"
else
  DIRECTORY="$PWD/jenkins/"
fi

docker build --tag devops-demo:jenkins $DIRECTORY
