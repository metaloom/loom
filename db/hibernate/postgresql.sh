#!/bin/bash

TAG=13.1-alpine

docker run --rm --name postgres \
 -e POSTGRES_PASSWORD=loom \
 -e POSTGRES_USER=loom \
 -e POSTGRES_DB=hreact \
 -p 5432:5432 \
 postgres:$TAG
