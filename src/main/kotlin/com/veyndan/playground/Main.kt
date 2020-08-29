package com.veyndan.playground

import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import org.postgresql.ds.PGSimpleDataSource

fun main() {
    val dataSource = PGSimpleDataSource().apply {
        portNumbers = intArrayOf(5432)
        databaseName = "postgres"
    }

    val driver = dataSource.asJdbcDriver()

    val database = test_database(driver)
    test_database.Schema.create(driver)
}
