plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.practic"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.practic"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

        // RxJava (Core) - библиотека для работы с реактивным программированием
        implementation (libs.rxjava) // (RxJava 2.x для создания и работы с потоками данных)

        // RxAndroid для работы с потоками на Android - помогает управлять потоками на Android, в том числе переключаться на главный поток
        implementation (libs.rxandroid) // (Поддержка потоков в Android, включая RxJavaSchedulers)

        // Для интеграции с LiveData - устаревшая зависимость для работы с LiveData в старых версиях библиотеки
        implementation (libs.androidx.lifecycle.extensions) // (Обеспечивает работу с LiveData и ViewModel)

        // Котлин синтаксис (если нужно) - для работы с Kotlin
        implementation (libs.kotlin.stdlib.jdk7) // (Стандартная библиотека Kotlin для Java 7)


    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}