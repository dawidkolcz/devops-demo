#!/bin/bash

docker run -p 8080:80 --detach --network devops-demo --rm --name frontend devops-demo:frontend
