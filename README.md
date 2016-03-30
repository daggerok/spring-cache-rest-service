spring-cache-rest-service [![build](https://api.travis-ci.org/daggerok/spring-cache-rest-service.svg?branch=master)](https://travis-ci.org/daggerok/spring-cache-rest-service)
=========================

caching rest services with spring easy, as 1, 2, 3... :)

```sh
git clone ...
cd ...
gradle clean build bootRun
```

send twice same request

```sh
curl localhost:8080
curl localhost:8080/1
curl localhost:8080/1
curl localhost:8080
```

and verify log output for single result

```sh
2016-03-30 03:51:54.865  INFO 72609 --- [nio-8080-exec-1] com.daggerok.microrest.domain.BookRest   : getting all...
2016-03-30 03:52:00.651  INFO 72609 --- [nio-8080-exec-3] com.daggerok.microrest.domain.BookRest   : getting one 1
```

which is mean, that on first call result value cached, and method will not call again for same input
