import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.10"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.32"
	kotlin("plugin.spring") version "1.5.32"
	kotlin("plugin.allopen") version "1.5.32"
	kotlin("kapt") version "1.5.32"
	kotlin("plugin.noarg") version "1.5.32"
}
group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8
val qeurydslVersion = "4.4.0" // <= 추가 설정

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

noArg {
	annotation("com.example.kotlinTest")
}
repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	//코틀린 관련
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	//직렬화 플러그인
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.0")

	//kotlin datetime 플러그인
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")

	// QueryDSL
	implementation("com.querydsl:querydsl-jpa:$qeurydslVersion")
	kapt("com.querydsl:querydsl-apt:$qeurydslVersion:jpa")
	kapt("org.springframework.boot:spring-boot-configuration-processor")

	//redis 추가
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	//data jpa
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
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
