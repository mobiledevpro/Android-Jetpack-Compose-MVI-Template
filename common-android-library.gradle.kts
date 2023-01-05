plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    compileSdkVersion rootProject.compileSdkVersion

    defaultConfig {
        minSdkVersion rootProject.minSdkVersion
        targetSdkVersion rootProject.targetSdkVersion
        versionCode rootProject.appVersionCode
        versionName rootProject.appVersionName

        consumerProguardFiles "consumer-rules.pro"
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildTypes {
        debug {
            debuggable true
        }
        release {
            debuggable false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    sourceSets {
        main {
            java.srcDirs = ['src/main/kotlin']
        }
    }

    flavorDimensions "default"
    productFlavors {
        production {
            dimension "default"
            buildConfigField 'String', 'VERSION_NAME', "\"${rootProject.appVersionName}\""
        }

        dev {
            dimension "default"
            buildConfigField 'String', 'VERSION_NAME', "\"${rootProject.appVersionName}\""
        }
    }

    buildFeatures.buildConfig = true
}