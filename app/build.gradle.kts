plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// NOTE: Is file mein `repositories { ... }` block nahi hona chahiye.
// Kyunki woh `settings.gradle.kts` mein pehle se define hai.

android {
    namespace = "com.premiumhub"
    compileSdk = 34 // Tip: Ise latest 34 par rakhein

    defaultConfig {
        applicationId = "com.premiumhub"
        minSdk = 21
        targetSdk = 34 // Tip: Ise bhi latest 34 par rakhein
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
        // Yeh line Jetpack Compose ko enable karti hai
        compose = true
    }
    
    // Yahan par version number theek kiya gaya hai
    composeOptions {
        // Kotlin 1.9.20 ke liye compatible version 1.5.4 hai.
        // Aapka 1.5.14 ek typo tha.
        kotlinCompilerExtensionVersion = "1.5.4" 
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // BOM (Bill of Materials) aapki saari compose libraries ka version manage karta hai
    // 2024.02.02 is a stable recent version.
    implementation(platform("androidx.compose:compose-bom:2024.02.02"))

    // Compose ki zaroori dependencies
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Baaki dependencies
    // implementation("androidx.core:core-ktx:1.12.0")
    // implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Test dependencies
    // testImplementation("junit:junit:4.13.2")
    //androidTestImplementation("androidx.test.ext:junit:1.1.5")
    //androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.02"))
    //androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    //debugImplementation("androidx.compose.ui:ui-tooling")
    //debugImplementation("androidx.compose.ui:ui-test-manifest")
}
