FROM nginx
RUN rm -f /etc/nginx/conf.d/default.conf
RUN rm -f /etc/nginx/conf.d/example_ssl.conf
COPY content /usr/share/nginx/html
COPY conf /etc/nginx