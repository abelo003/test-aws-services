IMAGE_NAME:=abelo003/test-aws-service
IMAGE_TAG:=latest

default:
	cat ./Makefile
dist: keystore
	./mvnw clean package
image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .
run:
	docker run -d -p 8080:8080  -p 8443:8443 $(IMAGE_NAME):$(IMAGE_TAG)
run-bash:
	docker run -d -t $(IMAGE_NAME):$(IMAGE_TAG) /bin/bash
keystore:
	@./generate-keystore.sh
chart:
	cd deployment/k8s/helm && make package
all: dist image chart
up: all run