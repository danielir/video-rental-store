curl -H "Content-Type: application/json" -X POST -d '{"name":"alejandro"}' http://localhost:8080/customers
curl -H "Content-Type: application/json" -X POST -d '{"name":"dani"}' http://localhost:8080/customers

curl -H "Content-Type: application/json" -X POST -d '{"name":"Bob Esponja"}' http://localhost:8080/films
curl -H "Content-Type: application/json" -X POST -d '{"name":"Jorge El curioso"}' http://localhost:8080/films

curl -H "Content-Type: application/json" -X POST -d '{"customer_id":1,"film_id":1}' http://localhost:8080/rentals

