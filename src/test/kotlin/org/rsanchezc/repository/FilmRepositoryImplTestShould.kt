package org.rsanchezc.repository

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.rsanchezc.domain.Order
import org.rsanchezc.utils.Films.COCO
import org.rsanchezc.utils.Films.KLAUS
import org.slf4j.LoggerFactory.*
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import javax.sql.DataSource

/**
Examples
https://github.com/testcontainers/testcontainers-java/issues/318
https://github.com/robfrank/testcontainers-examples
 */

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class FilmRepositoryImplTestShould {

    private val logger = getLogger(javaClass)

    @Container
    val mysql = MySQLContainer<Nothing>("mysql:5.7").apply {
        withExposedPorts(3308)
        withLogConsumer { Slf4jLogConsumer(logger) }
        withInitScript("init.sql")
    }

    @BeforeAll
    fun setUp() = mysql.start()

    @Test
    fun `return films ordered by rating`() {
        val filmRepository = FilmRepositoryImpl(getDataSource().connection)
        assertEquals(listOf(KLAUS, COCO), filmRepository.findAllOrderByRating(Order.DESC))
    }

    private fun getDataSource(): DataSource {
        val config = HikariConfig()
        config.jdbcUrl = mysql.jdbcUrl
        config.username = mysql.username
        config.password = mysql.password
        config.driverClassName = mysql.driverClassName

        return HikariDataSource(config)
    }
}