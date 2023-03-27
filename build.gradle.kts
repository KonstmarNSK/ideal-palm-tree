import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
	kotlin("plugin.jpa") version "1.8.10"
    kotlin("kapt") version "1.8.10"
//    id("at.comm_unity.gradle.plugins.jpamodelgen") version("1.1.4")
}

group = "com.kostya"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.hibernate:hibernate-jpamodelgen:6.2.0.CR4")
    kapt("org.hibernate:hibernate-jpamodelgen:6.2.0.CR4")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

//compileKotlin.options.annotationProcessorGeneratedSourcesDirectory = file("${buildDir}/generated/source/apt")

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}

}

tasks.withType<Test> {
	useJUnitPlatform()
}
