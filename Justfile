load:
  docker-compose down --rmi all --volumes --remove-orphans
  rm -rf ./docker/db/mongo/db/
  docker-compose up -d --build