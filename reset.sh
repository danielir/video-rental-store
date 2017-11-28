mvn package
rm target/example*
java -jar target/video-rental-store-1.0-SNAPSHOT.jar db migrate example.yml
java -jar target/video-rental-store-1.0-SNAPSHOT.jar server example.yml
