#!/bin/bash

REPO_DIR=$(pwd|sed 's/\/jenkins//')
docker run --name jenkins --network devops-demo --detach --rm \
  --publish 9090:8080 --publish 50000:50000 \
  --privileged \
  -v /var/run/docker.sock:/var/run/docker.sock \
  --volume $REPO_DIR:/repo \
  --volume jenkins_home:/var/jenkins_home \
  -u root \
  devops-demo:jenkins
