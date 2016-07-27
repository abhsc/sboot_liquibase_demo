#!/bin/bash
clear
docker rm -f $(docker ps -aq)
clear 
echo 'Live Demo Time' |  figlet -w 90 | lolcat

#1. Deploy v1.0 Blue to app1 & app2
#    - start PG, apps, nginx
echo -n "docker run -d --env=POSTGRES_PASSWORD=demo_pass  -p 5432:5432  --name sboot_demo_pg sboot_demo_pg"
read x
docker run -d --env=POSTGRES_PASSWORD=demo_pass  -p 5432:5432  --name sboot_demo_pg sboot_demo_pg

echo -n "docker run -d --name v1.0-blue1 -p 8180:8180 -e app.version=\"v1.0-blue-node1\"  --link sboot_demo_pg:sboot_demo_pg sboot:v1.0-blue"
read x
docker run -d --name v1.0-blue1 -p 8180:8180 -e app.version="v1.0-blue-node1"  --link sboot_demo_pg:sboot_demo_pg sboot:v1.0-blue

echo -n "docker run -d --name v1.0-blue2 -p 8280:8180 -e app.version=\"v1.0-blue-node2\"  --link sboot_demo_pg:sboot_demo_pg sboot:v1.0-blue"
read x
docker run -d --name v1.0-blue2 -p 8280:8180 -e app.version="v1.0-blue-node2"  --link sboot_demo_pg:sboot_demo_pg sboot:v1.0-blue

echo -n "docker run -P -d --name ng -p 80:80 nginx_img"
read x
docker run -P -d --name ng -p 80:80 nginx_img

echo -n "docker ps"
read x
docker ps

#	- show liquibase in the logs executed as part of deployment
echo -n "docker logs v1.0-blue1"
read x
docker logs v1.0-blue1

#2. Launch loadbalancer url (http://localhost/SpringIODemo/demoPage)
#	- explain UI capturing User information including email address
#	- demo inserting a couple of records
echo -n "open -a Google\ Chrome http://localhost/SpringIODemo/demoPage"
read x
clear
open -a Google\ Chrome http://localhost/SpringIODemo/demoPage

#3. Deploy v1.1 Green to app1
echo -n "docker rm -f v1.0-blue1"
read x
docker rm -f v1.0-blue1

echo -n "docker run -d --name v1.1-green1 -p 8180:8180 -e app.version=\"v1.1-green-node1\" --link sboot_demo_pg:sboot_demo_pg sboot:v1.1-green"
read x
docker run -d --name v1.1-green1 -p 8180:8180 -e app.version="v1.1-green-node1" --link sboot_demo_pg:sboot_demo_pg sboot:v1.1-green

#	- loadbalancer loading from both nodes
echo -n "open -a Google\ Chrome http://localhost/SpringIODemo/demoPage"
read x
open -a Google\ Chrome http://localhost/SpringIODemo/demoPage

#	- show liquibase in the logs executed as part of deployment
echo -n "docker logs v1.1-green1"
read x
docker logs v1.1-green1

#	- old functionality working as expected
echo -n "open -a Google\ Chrome http://localhost:8280/SpringIODemo/demoPage"
read x
open -a Google\ Chrome http://localhost:8280/SpringIODemo/demoPage

#	- new functionality working as expected
echo -n "open -a Google\ Chrome http://localhost:8180/SpringIODemo/demoPage"
read x
clear
open -a Google\ Chrome http://localhost:8180/SpringIODemo/demoPage

#7. Deploy v1.1 Green to app2
echo -n "docker rm -f v1.0-blue2"
read x
docker rm -f v1.0-blue2

echo -n "docker run -d --name v1.1-green2 -p 8280:8180 -e app.version=\"v1.1-green-node2\"  -e liquibase.parameters.cleanupRun="true" --link sboot_demo_pg:sboot_demo_pg sboot:v1.1-green"
read x
docker run -d --name v1.1-green2 -p 8280:8180 -e app.version="v1.1-green-node2"  -e liquibase.parameters.cleanupRun="true" --link sboot_demo_pg:sboot_demo_pg sboot:v1.1-green

#	- show liquibase in the logs executed as part of deployment
echo -n "docker logs v1.1-green2"
read x
docker logs v1.1-green2

#	- app working as expected
echo -n "open -a Google\ Chrome http://localhost/SpringIODemo/demoPage"
read x
clear
open -a Google\ Chrome http://localhost/SpringIODemo/demoPage
