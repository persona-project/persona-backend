# persona-backend

The backend for persona project, using spring.


## Architecture

`MySQL` --- (offline) ---> `Spark` ---> `Redis` ---> `Web(Spring)`
`flume` ---> `Kafka` ---> `SparkStreaming` --- (real-time) ---> `Web(Spring)`
`MySQL` --- (real-time) ---> `Web(Spring)`

For more details: <https://github.com/persona-project/persona-core>


## License

> MIT License
> 
> Copyright (c) 2020 Persona
