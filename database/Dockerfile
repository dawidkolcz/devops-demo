FROM postgres:14.1

ENV POSTGRES_PASSWORD=postgres

COPY database.sql /docker-entrypoint-initdb.d/database.sql
