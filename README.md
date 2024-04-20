## TO RUN THIS PROJECT YOU WILL NEED TO
* Change the values of sample.application.properties and change the name to application.properties

* Run ./gradlew build

* And run docker build -t myorg/apollo-cars .

* docker run -p 8080:8080 myorg/apollo-cars

## To run without docker, you can just run: 
* ./gradlew bootRun 

## This project uses NoSQL database, please, provide a mongoDB database.