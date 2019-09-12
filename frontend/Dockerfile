FROM node:alpine
LABEL maintainer="paipweb@paipweb.com"

RUN apt update \
    && apt install -y build-essential curl gnupg wget software-properties-common apache2 \
	&& rm -r /var/lib/apt/lists/* \
    && apt clean

COPY . /app
WORKDIR /app

RUN sed -i "s@\/dist\/app.js@/dist/app.js?$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 32 | head -n 1)@" ./public/index.html

RUN yarn install --frozen-lockfile --non-interactive
RUN yarn build

COPY ./docker/docker-entrypoint.sh /usr/local/bin/docker-entrypoint
CMD ["docker-entrypoint"]
