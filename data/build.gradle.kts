plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.example.data"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(Deps.UI.androidCore)
    testImplementation(Deps.UI.junit)
    androidTestImplementation(Deps.UI.extJunit)

    //Room
    implementation(Deps.Room.room)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.runtime)

    //Dagger-Hilt
    implementation(Deps.Javax.inject)

    //Coroutines
    implementation(Deps.Coroutines.android)
}