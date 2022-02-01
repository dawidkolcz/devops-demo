#!/bin/bash

# docker build --tag devops-demo:database .
if [[ $PWD == *"database" ]]; then
  DIRECTORY="$PWD"
else
  DIRECTORY="$PWD/database/"
fi

docker build --tag devops-demo:database $DIRECTORY

