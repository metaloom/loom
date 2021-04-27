#!/bin/bash

docker run --name postgres -p 5432:5432 --rm -e POSTGRES_PASSWORD=finger postgres:13.2