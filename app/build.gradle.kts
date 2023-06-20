import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKapt)
}

android {
    namespace = "org.hxl.cinescope"
    compileSdk = 33

    defaultConfig {
        applicationId = "org.hxl.cinescope"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0-alpha.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        if (project.rootProject.file("local.properties").exists()) {
            val properties = Properties()
            properties.load(project.rootProject.file("local.properties").inputStream())
            buildConfigField("String", "API_TOKEN", "\"${properties.getProperty("API_TOKEN")}\"")
        }
        else {
            buildConfigField("String", "API_TOKEN", "\"dummytoken\"")
        }


    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:datastore"))
    implementation(project(":feature:onboard"))
    implementation(project(":feature:navigator"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.common)
    implementation(libs.koin.android)
    implementation(libs.koin.test)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.espresso.contrib)
    androidTestImplementation(libs.androidx.fragment.testing)
    androidTestImplementation(libs.androidx.navigation.testing)

    debugImplementation(libs.androidx.fragment.testing.manifest)
}