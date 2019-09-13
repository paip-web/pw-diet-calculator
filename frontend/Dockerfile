FROM node:alpine
LABEL maintainer="paipweb@paipweb.com"

RUN apk add apache2 openrc

COPY . /app
WORKDIR /app

RUN sed -i "s@\/dist\/app.js@/dist/app.js?$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 32 | head -n 1)@" ./public/index.html

RUN yarn install --frozen-lockfile --non-interactive
RUN yarn build

COPY ./docker/docker-entrypoint.sh /usr/local/bin/docker-entrypoint
RUN chmod +x /usr/local/bin/docker-entrypoint
CMD ["docker-entrypoint"]
