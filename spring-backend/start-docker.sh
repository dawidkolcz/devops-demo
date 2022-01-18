#!/bin/bash

docker run --network devops-demo -p 8081:8081 --rm --name backend devops-demo:backend
