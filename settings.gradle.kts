pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.squareup.sqldelight") {
                useModule("com.squareup.sqldelight:gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "sqldelight-playground"

//includeBuild("../sqldelight") {
//    dependencySubstitution {
//        substitute(module("com.squareup.sqldelight:gradle-plugin")).with(project(":sqldelight-gradle-plugin"))
//        substitute(module("com.squareup.sqldelight:runtime-jvm")).with(project(":runtime"))
//        substitute(module("com.squareup.sqldelight:jdbc-driver")).with(project(":drivers:jdbc-driver"))
//    }
//}
