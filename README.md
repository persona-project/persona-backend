# persona-backend
The backend for persona project, using spring and spark to build a big data platform. 


## Architecture
`MySQL` ---(real-time)---> `Spark` ---> `Web(Spring)`

will be considered:
- `flume`: real-time data collecting
- `spark`: offline data processing
- `spark streaming`: real-time data processing
- `redis`: cache
- `MySQL`: as one of the data input source


## Reference
<https://zhuanlan.zhihu.com/p/36082771>


## License

> MIT License
> 
> Copyright (c) 2020 Persona
