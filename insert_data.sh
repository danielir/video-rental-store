curl -H "Content-Type: application/json" -X POST -d '{"name":"alejandro"}' http://localhost:8080/customers
curl -H "Content-Type: application/json" -X POST -d '{"name":"dani"}' http://localhost:8080/customers

curl -H "Content-Type: application/json" -X POST -d '{"name":"Bob Esponja", "type":"NEW_RELEASE"}' http://localhost:8080/films
curl -H "Content-Type: application/json" -X POST -d '{"name":"Jorge El curioso", "type":"OLD"}' http://localhost:8080/films

curl -H "Content-Type: application/json" -X POST -d '{"filmType":"NEW_RELEASE", "price":40. "days":1}' http://localhost:8080/prices



curl -H "Content-Type: application/json" -X POST -d '{"customerId":100, "filmRentRequests":[ {"filmId":1, "days":1} ]}' http://localhost:8080/rent

#curl -H "Content-Type: application/json" -X POST -d '{"customer_id":1,"film_id":1}' http://localhost:8080/rentals

