plugins {
	id ("org.springframework.boot") version "2.2.2.RELEASE"
	id ("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("com.bmuschko.docker-spring-boot-application") version "6.1.1"
	java
}

group = "com.kish.learning"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")
	implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-hystrix")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-ribbon")

	implementation("org.springframework.boot","spring-boot-starter-actuator")

	implementation("org.springframework.cloud","spring-cloud-starter-kubernetes-all")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude ("org.junit.vintage","junit-vintage-engine")
	}
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR1")
	}
}

tasks.withType<Test>{
	useJUnitPlatform()
}

docker {
	springBootApplication {
		baseImage.set("openjdk:13-alpine")
		ports.set(listOf(9002, 9002))
		images.set(setOf("kubegateway:0.0.1", "kubegateway:latest"))
		jvmArgs.set(listOf("-Xmx2048m"))
	}
}