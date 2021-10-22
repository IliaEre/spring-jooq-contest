## Simple service with JOOQ
### version 0.0.1

##### Warning! The service is just simple example, you shouldn't use the same configuration on production aria.

### Bases:
1) plugin:  
id("com.rohanprabhu.kotlin-dsl-jooq") version "0.4.6"
   (available here)[https://github.com/rohanprabhu/kotlin-dsl-gradle-jooq-plugin]

2) dependencies:
```kotlin
    jooqGeneratorRuntime("org.postgresql:postgresql:42.1.4")
    runtimeOnly("org.postgresql:postgresql")
```

3) there are three cases for jooq generator
 > classic with connection to DB (primary)  
 > generate xml from DB  
 > generate pojo form XML  
 
### service has composes file: 
```bash
version: '3.1'

services:
  db:
    image: postgres
    restart: always
    environment:
      POSTGRES_PASSWORD: pwd
    ports:
      - 5432:5432
  adminer:
    image: adminer
    restart: always
    ports:
      - 8080:8080
```

What next?
1) tests
2) test containers
3) code style
