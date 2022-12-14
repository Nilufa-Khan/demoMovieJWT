FROM openjdk
WORKDIR usr/lib

ENV MONGO_DATABASE="wave33moviedb"
ENV MONGO_URL="mongodb://localhost:27017/wave33moviedb"

ADD ./target/demoMovieJWT-0.0.1-SNAPSHOT.jar /usr/lib/demoMovieJWT-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","demoMovieJWT-0.0.1-SNAPSHOT.jar"]