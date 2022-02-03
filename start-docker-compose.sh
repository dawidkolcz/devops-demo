#!/bin/bash

COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose -f /repo/docker-compose.yml create && \
docker-compose -f /repo/docker-compose.yml start
