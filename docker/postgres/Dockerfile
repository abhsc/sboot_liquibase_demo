FROM postgres:9.5.3
# FROM postgres
MAINTAINER Alan Barrington-Hughes <alan_barrington-hughes@premierinc.com> 
ENV DB_NAME sboot_demo
ENV DB_USER demo
ENV DB_PASS demo_pass
ADD setupRemoteConnections.sh /docker-entrypoint-initdb.d/setupRemoteConnections.sh
RUN chmod 755 /docker-entrypoint-initdb.d/setupRemoteConnections.sh
ADD setup-database.sh /docker-entrypoint-initdb.d/
RUN chmod 755 /docker-entrypoint-initdb.d/setup-database.sh

