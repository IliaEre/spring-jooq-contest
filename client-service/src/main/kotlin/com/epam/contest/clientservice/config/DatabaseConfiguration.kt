package com.epam.contest.clientservice.config

import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

/**
 * We can create own beans and datasource
 * if we need to connect to two or more DB we should create beans
 *
 * we can use @ConfigurationProperties with prefix and use default spring fields
 * */
@Configuration
@ConditionalOnProperty(prefix = "spring.profiles", name = ["active"], havingValue = "custom")
class DatabaseConfiguration {

    @Primary
    @Bean("importantDb")
    @ConfigurationProperties(prefix = "spring.in.datasource")
    fun importantDatabase(): DataSource = DataSourceBuilder.create().build()

    @Primary
    @Bean("importantDbContext")
    fun importantDatabaseContext(@Qualifier("importantDb") dataSource: DataSource): DSLContext =
        DSL.using(dataSource, SQLDialect.POSTGRES)
}
