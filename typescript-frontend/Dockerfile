FROM node:17-alpine as build

ENV NODE_ENV=production
RUN npm install -g typescript@latest
WORKDIR ./app
COPY ["package.json", "tsconfig.json", "./"] 
COPY ["index.html", "index.tsx", "./"]
RUN npm install 
RUN tsc

FROM nginx:alpine

COPY server.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app /usr/share/nginx/html/
