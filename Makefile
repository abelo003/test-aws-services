IMAGE_NAME:=abelo003/test-aws-service
IMAGE_TAG:=latest

default:
	cat ./Makefile
dist: keystore
	./mvnw clean package
pull-auxiliary-images:
	docker-compose pull mongo
start-auxiliary-services:
	docker-compose up -d mongo
image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .
run:
	docker-compose up aws-service
	#docker run -d -p 8080:8080 -p 8443:8443 $(IMAGE_NAME):$(IMAGE_TAG)
run-bash:
	docker run -d -t $(IMAGE_NAME):$(IMAGE_TAG) /bin/bash
stop:
	docker-compose down
keystore:
	@./generate-keystore.sh
chart:
	cd deployment/k8s/helm && make package
all: dist image chart
up: all run