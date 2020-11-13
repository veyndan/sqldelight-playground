package com.veyndan.playground

import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import org.postgresql.ds.PGSimpleDataSource

data class Age(val months: Int)

fun main() {
    val dataSource = PGSimpleDataSource().apply {
        portNumbers = intArrayOf(5432)
        databaseName = "postgres"
    }

    val driver = dataSource.asJdbcDriver()

    val ageInYearsAdapter = object : ColumnAdapter<Age, Int> {
        override fun decode(databaseValue: Int): Age = Age(databaseValue * 12)

        override fun encode(value: Age): Int = value.months / 12
    }
    val ageInMonthsAdapter = object : ColumnAdapter<Age, Int> {
        override fun decode(databaseValue: Int): Age = Age(databaseValue)

        override fun encode(value: Age): Int = value.months
    }

    val database = test_database(
        driver,
        Adults.Adapter(ageInYearsAdapter),
        Children.Adapter(ageInMonthsAdapter)
    )
    test_database.Schema.create(driver)

    // The adapters for Adults#ageInYears and Children#ageInMonths aren't equal, so the proposed `check` would cause a
    // RuntimeException here.
    database.playgroundQueries.ages().executeAsList().forEach(::println)
}
