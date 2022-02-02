#!/bin/bash

function START_DEMO_USING_DOCKER(){
  echo "Building and running database..."
  ./database/build-docker.sh  
  ./database/start-docker.sh
  echo "Building and running spring-backend..."
  ./spring-backend/build-docker.sh 
  ./spring-backend/start-docker.sh
  echo "Building and running typescript-frontend..."
  ./typescript-frontend/build-docker.sh
  ./typescript-frontend/start-docker.sh
}

function START_DEMO_USING_DOCKER_COMPOSE(){
  CHECK_FOR_DOCKER_COMPOSE
  ./start-docker-compose.sh
}

function START_DEMO_USING_JENKINS(){
  echo "Building and runnign jenkins..."
  ./jenkins/build-docker.sh
  ./jenkins/start-docker.sh
}

function CHECK_FOR_DOCKER_COMPOSE(){
  echo "Checking for docker-compose..."
  if DOCKER_COMPOSE_PATH=$(which docker-compose); then
    echo "Docker compose found."
  else
    echo "Docker compose not found, you can still start application using docker."
    exit 1
  fi
}

function CHECK_FOR_DOCKER(){
  echo "Checking for docker..."
  if DOCKER_PATH=$(which docker); then
    echo "[Info] Docker found."
  else
    echo "[Error] Docker not found. Demo will not start without docker."
    exit 1
  fi
}

echo "--- Devops-demo ---"
CHECK_FOR_DOCKER
echo "How would you like to start demo ?"
echo "[1] Using jenkins, will use custom docker image"
echo "[2] Using docker-compose, will be used to start all docker files not by docker pipeline"
echo "[3] Using docker, will use start-demo.sh to build, run all containers."

until [[ $CHOICE =~ [123] ]]; do
  read -p "Option: " -r CHOICE
  echo $CHOICE
  case $CHOICE in
  1)
    echo "Starting demo using jenkins..."
    START_DEMO_USING_JENKINS
    ;;
  2)
    echo "Starting demo using docker-compose..."
   START_DEMO_USING_DOCKER_COMPOSE
    ;;
  3)
    echo "Starting demo using docker..."
    START_DEMO_USING_DOCKER
    ;;
  *)
    echo "Only 1,2 or 3 is a valid choice, ctr+c to quit."
    ;;
  esac
done

exit 0
