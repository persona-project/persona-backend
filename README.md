# persona-backend

The backend for persona project, using spring.


## Architecture

- for data not changing frequently:
`MySQL` --- (offline) ---> `Spark` ---> `Redis` ---> `Web(Spring)`  

- for duration data:
`MySQL` --- (real-time) ---> `Web(Spring)`  

- for log:
`flume` ---> `Kafka` ---> `SparkStreaming` --- (real-time) ---> `Web(Spring)`  
  
For more details: <https://github.com/persona-project/persona-core>


## License

> MIT License
> 
> Copyright (c) 2020 Persona
