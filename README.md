<h2>Run Application</h2>

```
./mvnw spring-boot:run
```

<h2>Camunda Web App page</h2>

Can be found [here](http://localhost:8080/app/welcome/default/#!/login)

Credentials: `admin:admin`

<h2>To test BPM process </h2>

```
GET http://localhost:8080/test?param=param_value
```

Supports optional request parameter `param` that be passed into demo process (default value is `default`)

<h2>TBD</h2>
* Configure non-h2 database for Camunda
* Create and support process that will call our application from it's block
* Update API for usability
