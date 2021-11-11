import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.rohanprabhu.gradle.plugins.kdjooq.*

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    // follow here: https://github.com/rohanprabhu/kotlin-dsl-gradle-jooq-plugin
    id("com.rohanprabhu.kotlin-dsl-jooq") version "0.4.6"
    // follow here: https://flywaydb.org/documentation/getstarted/firststeps/gradle
    id ("org.flywaydb.flyway") version "8.0.2"
}

group = "com.epam.stock"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // added jooq generator
    jooqGeneratorRuntime("org.postgresql:postgresql:42.1.4")
    runtimeOnly("org.postgresql:postgresql")
    // https://mvnrepository.com/artifact/org.flywaydb/flyway-core
    implementation("org.flywaydb:flyway-core:8.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// we should create a task like:
jooqGenerator {
    configuration("primary", project.java.sourceSets.getByName("main")) {
        configuration = jooqCodegenConfiguration {
            jdbc {
                username = "postgres"
                password = "pwd"
                driver = "org.postgresql.Driver"
                url = "jdbc:postgresql://localhost:5432/postgres"
            }

            generator {
                target {
                    packageName = "com.epam.jooq"
                    directory = "./src/main/java"
                }

                generate {
                    isGeneratedAnnotation = false
                    isRelations = true
                    isDeprecated = false
                    isRecords = true
                    isImmutablePojos = true
                    isFluentSetters = true
                    isJavaTimeTypes = true
                }

                database {
                    name = "org.jooq.meta.postgres.PostgresDatabase"
                    inputSchema = "public"
                    includes = "product|description"
                }
            }
        }
    }
    configuration("xml", project.java.sourceSets.getByName("main")) {
        configuration = jooqCodegenConfiguration {
            jdbc {
                username = "postgres"
                password = "pwd"
                driver = "org.postgresql.Driver"
                url = "jdbc:postgresql://localhost:5432/postgres"
            }

            generator {
                name = "org.jooq.codegen.XMLGenerator"
                target {
                    directory = "src/main/resources/generated"
                }
                database {
                    name = "org.jooq.meta.postgres.PostgresDatabase"
                    inputSchema = "public"
                    includes = "product|description"
                }
            }
        }
    }
    configuration("from-xml", project.java.sourceSets.getByName("main")) {
        configuration = jooqCodegenConfiguration {
            generator {
                database {
                    name = "org.jooq.meta.xml.XMLDatabase"
                    inputSchema = "public"
                    includes = ".*"
                    properties.add(
                        org.jooq.meta.jaxb.Property()
                            .withKey("dialect")
                            .withValue("postgres")
                    )
                    properties.add(
                        org.jooq.meta.jaxb.Property()
                            .withKey("xmlFile")
                            .withValue("src/main/resources/generated/org/jooq/generated/information_schema.xml")
                    )
                }
                generate {
                    isGeneratedAnnotation = false
                    isRelations = true
                    isDeprecated = false
                    isRecords = true
                    isImmutablePojos = true
                    isFluentSetters = true
                    isJavaTimeTypes = true
                }

                target {
                    packageName = "com.epam.jooq"
                    directory = "./src/main/java/new"
                }
            }
        }
    }
}

flyway {
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "pwd"
}

tasks.getByName("jooq-codegen-from-xml") {
    enabled = false
}

tasks.getByName("jooq-codegen-xml") {
    enabled = false
}

tasks.getByName("jooq-codegen-primary") {
    enabled = false
}
