import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.rohanprabhu.gradle.plugins.kdjooq.*

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    // follow here: https://github.com/rohanprabhu/kotlin-dsl-gradle-jooq-plugin
    id("com.rohanprabhu.kotlin-dsl-jooq") version "0.4.6"
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
                    directory = "${project.buildDir}/generated/jooq/primary"
                }

                database {
                    name = "org.jooq.meta.postgres.PostgresDatabase"
                    inputSchema = "public"
                    includes = "product|description"
                }
            }
        }
    }
}
