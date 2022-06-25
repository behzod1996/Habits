plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Configuration.compileSdkVersion

    defaultConfig {
        applicationId = Configuration.applicationId
        minSdk = Configuration.minSdkVersion
        targetSdk = Configuration.targetSdkVersion
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName

        testInstrumentationRunner = Configuration.testInstrumentationRunner
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

    viewBinding.isEnabled = true
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to
            listOf("*.jar", "*.arr"))))

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.2")
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    hilt()
    hiltKapt()

    coroutineAndroid()
    coroutineCore()

    lifecycleLiveData()
    lifecycleRuntime()
    lifecycleViewModel()
    fragmentKtx()

    navigationUi()
    navigationFragment()

    implementation(project(":common-data"))
    implementation(project(":common-ui"))
    implementation(project(":feature-splash"))
    implementation(project(":feature-onboarding"))
    implementation(project(":feature-home"))
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableExperimentalClasspathAggregation = true
}
