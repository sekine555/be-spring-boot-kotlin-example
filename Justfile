load:
  docker-compose -f "./docker-compose.yml" down --rmi all --volumes --remove-orphans
  rm -rf ./docker/db/mongo/db/
  docker-compose -f "./docker-compose.yml" up -d --build