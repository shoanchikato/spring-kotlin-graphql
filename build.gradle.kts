import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.31"
	kotlin("plugin.spring") version "1.4.31"
}

group = "com.sample"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {

	// retrofit
	val retrofit = "2.7.2"
	implementation("com.squareup.retrofit2:retrofit:$retrofit")
	implementation("com.squareup.retrofit2:retrofit:$retrofit")
	implementation("com.squareup.retrofit2:converter-gson:$retrofit")
	val okhttp = "4.9.0"
	implementation("com.squareup.okhttp3:okhttp:$okhttp")
	implementation("com.squareup.okhttp3:logging-interceptor:$okhttp")

	implementation("com.expediagroup:graphql-kotlin-spring-server:4.0.0-alpha.0")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
