FROM ubuntu:latest
FROM openjdk:23-jdk-slim AS build
LABEL authors="admin.ian.swerts"
WORKDIR /school2
COPY . .

ENTRYPOINT ["top", "-b"]