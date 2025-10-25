plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "1.9.+" apply false // Flexible version
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") } // Fixed syntax for Kotlin DSL
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.0") // Latest Gradle plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20") // Match with Kotlin version
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") } // Ensure plugin resolution
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
