plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.dagger.hilt.android)
}

android {
    namespace = "com.app.vocab"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.vocab"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://random-word-api.herokuapp.com/word?number=50\""
            )
        }
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled =  false
            isShrinkResources =  false
            isDebuggable =  false

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://random-word-api.herokuapp.com/word?number=50\""
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
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // core libs
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.play.services)

    // compose
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // tooling and preview
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)

    // Compose - Material Design 3
    implementation(libs.androidx.material3)
    implementation(libs.compose.material3)
    implementation(libs.compose.material.icons.extended)
    implementation(libs.androidx.compose.material3.adaptive.navigation)

    // Compose - Integration with ViewModels
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Compose - Integration with Activities
    implementation(libs.androidx.activity.compose)

    // Compose - Testing
    androidTestImplementation(libs.compose.junit)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.rules)
    androidTestImplementation(libs.androidx.uiautomator)
    androidTestImplementation(libs.truth)
    debugImplementation(libs.androidx.ui.test.manifest)
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Accompanist - Permissions
    implementation(libs.accompanist.permissions)

    // benchmark
    implementation(libs.androidx.profileinstaller)

    // Ui and graphics
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)

    // Navigation class
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // data - store in android
    implementation(libs.androidx.datastore.preferences)

    // Hilt
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)

    // Hilt extension for compose
    implementation(libs.androidx.hilt.navigation.compose)

    // Set theme from Color
    implementation(libs.material.kolor)

    // firebase auth
    implementation(libs.firebase.auth)
    implementation(platform(libs.firebase.bom))
    implementation(libs.play.services.auth)

    // Firebase storage
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.storage)

    // splash screen
    implementation(libs.androidx.core.splashscreen)

    // Horizontal dots indicator
    implementation(libs.dotsindicator)

    // coil lib to load images
    implementation(libs.coil3.coil.compose)
    implementation(libs.coil.network.okhttp)

    // ktor
    implementation(libs.bundles.ktor)

    // compose-paging
    implementation(libs.androidx.paging.compose)

    //run-time paging
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.room.paging)

    // room database
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

}