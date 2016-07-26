#!/bin/bash
docker rm -f $(docker ps -aq)
clear 
echo 'Live Demo Time' |  figlet -w 90 | lolcat

#1. Deploy v1.0 Blue to app1 & app2
#    - start PG, apps, nginx
#	- show liquibase in the logs executed as part of deployment
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


echo -n "docker logs v1.0-blue1"
read x
docker logs v1.0-blue1


echo -n "open -a Google\ Chrome http://localhost/SpringIODemo/demoPage"
read x
open -a Google\ Chrome http://localhost/SpringIODemo/demoPage


#2. Launch loadbalancer url (http://localhost/SpringIODemo/demoPage)
#	- explain UI capturing User information including email address
#	- demo inserting a couple of records

#3. Explain enhancements to application
#	- capturing more than one email address
#	- explain the no outage solution by using triggers in v1.1 Green
#	- explain the strategy to cleanup triggers in the final run of v1.1 Green

#4. Deploy v1.1 Green to app1
#	- show liquibase executing as part of deployment (optional)
#    commands:
docker rm -f v1.0-blue1
docker run -d --name v1.1-green1 -p 8180:8180 -e app.version="v1.1-green-node1" --link sboot_demo_pg:sboot_demo_pg sboot:v1.1-green
docker logs v1.1-green1

#7. Deploy v1.1 Green to app2
docker rm -f v1.0-blue2
docker run -d --name v1.1-green2 -p 8280:8180 -e app.version="v1.1-green-node2"  -e liquibase.parameters.cleanupRun="true" --link sboot_demo_pg:sboot_demo_pg sboot:v1.1-green

docker logs v1.1-green2
