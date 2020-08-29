plugins {
    kotlin("jvm") version "1.4.0"
    id("com.squareup.sqldelight") version "1.4.4"
}

sqldelight {
    database("test_database") {
        packageName = "com.veyndan.playground"
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

repositories {
    mavenCentral()
}

dependencies {
}
