plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

    //Inject
    implementation(Deps.Javax.inject)

    //Coroutines core
    implementation(Deps.Coroutines.inject)
}