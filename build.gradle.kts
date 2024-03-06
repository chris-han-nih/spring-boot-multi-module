import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("plugin.spring") apply false
  id("org.springframework.boot") apply false
  id("io.spring.dependency-management") apply false
  kotlin("jvm") version "1.9.22"
}

java.sourceCompatibility = JavaVersion.VERSION_17

val projectGroup: String by project
val applicationVersion: String by project

allprojects {
  group = projectGroup
  version = applicationVersion

  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "org.jetbrains.kotlin.jvm")
  apply(plugin = "org.jetbrains.kotlin.plugin.spring")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")

  dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs += "-Xjsr305=strict"
      jvmTarget = "17"
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}
