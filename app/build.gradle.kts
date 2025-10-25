plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // No compose plugin
}

android {
    namespace = "com.premiumhub"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.premiumhub"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"  // Old way – for Kotlin 1.9.x
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Same as before, but BOM to 2023.10.01
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    // Rest same...
}
