plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "2.0.20" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false  // Now it exists!
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()  // Yeh add kar – plugin resolve ke liye zaroori
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()  // Yeh bhi add kar
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
