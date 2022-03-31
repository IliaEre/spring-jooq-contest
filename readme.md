## Simple service with JOOQ
### version 0.0.2

##### Warning! The service is just simple example, you shouldn't use the same configuration on production aria.

I highly recommend reading links:  
* I used gradle plugin for kts and jooq: [gradle plugin](https://github.com/rohanprabhu/kotlin-dsl-gradle-jooq-plugin)  
* You can find more information and download here: [Jooq pricing](https://www.jooq.org/download/)  
* Read more information about transactional: [Transactional](https://www.jooq.org/doc/latest/manual/sql-execution/transaction-management/)  
* Useful subject about Jooq [RUS]: [habr](https://habr.com/ru/post/488522/)
---
### Bases:
1) plugin:  
id("com.rohanprabhu.kotlin-dsl-jooq") version "0.4.6"

2) dependencies:
```kotlin
    jooqGeneratorRuntime("org.postgresql:postgresql:${VERSION}")
    runtimeOnly("org.postgresql:postgresql")
```

3) there are three cases for jooq generator
 > classic with connection to DB (primary)  
 > generate xml from DB  
 > generate pojo form XML  
 
4) run with simple compose file (You should have docker)

---
#### Exrta:
>`jooq-contest-maven` folder with maven samples
---
