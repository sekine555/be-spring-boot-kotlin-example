#!/bin/bash
mongoimport --db poc --collection order --drop \
            --file /docker-entrypoint-initdb.d/order.json \
            --jsonArray