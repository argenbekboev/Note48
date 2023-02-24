plugins {
    id (Plugins.AGP.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.note"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.note"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile ("proguard-android-optimize.txt"),
                    "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    //Room
    implementation(Deps.Room.runtime)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.room)

    //UI
    implementation(Deps.UI.androidCore)
    implementation(Deps.UI.appcompat)
    implementation(Deps.UI.material)
    implementation(Deps.UI.constraint)
    testImplementation(Deps.UI.junit)
    androidTestImplementation(Deps.UI.extJunit)
    androidTestImplementation(Deps.UI.espresso)

    //Fragment
    implementation(Deps.UI.fragment)

    //Dagger Hilt
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.compiler)

    //Navigation component
    implementation(Deps.NavigationComponent.fragment)
    implementation(Deps.NavigationComponent.ui)

    //LifeCycle
    implementation(Deps.LifeCycle.viewmodel)
    implementation(Deps.LifeCycle.runtime)

    //ViewBindingDelegateProperty
    implementation(Deps.ViewBindingDelegateProperty.ViewBindingPropertyDelegate)

}