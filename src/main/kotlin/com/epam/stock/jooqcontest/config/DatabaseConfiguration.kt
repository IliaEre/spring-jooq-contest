package com.epam.stock.jooqcontest.config

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
