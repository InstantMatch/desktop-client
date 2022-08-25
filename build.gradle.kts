import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0"
}

group = "me.jobinlawrance"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            macOS {
                iconFile.set(project.file("icons/instamatch_icon.icns"))
            }
            windows {
                iconFile.set(project.file("icons/instamatch_icon.ico"))
            }
            linux {
                iconFile.set(project.file("icons/instamatch_icon.png"))
            }
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "InstaMatch"
            packageVersion = "1.0.0"
        }
    }
}