plugins {
	id ("org.springframework.boot") version "2.2.2.RELEASE"
	id ("io.spring.dependency-management") version ("1.0.8.RELEASE")
	id("com.bmuschko.docker-spring-boot-application") version "6.1.1"
	java
}

group = "com.kish.learning"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}


dependencies {
	implementation ("de.codecentric","spring-boot-admin-starter-server")
	implementation ("org.springframework.cloud:spring-cloud-starter")
	implementation ("org.springframework.cloud:spring-cloud-starter-loadbalancer")
	implementation ("org.springframework.cloud:spring-cloud-starter-netflix-ribbon")
	implementation("org.springframework.boot","spring-boot-starter-actuator")
	implementation("org.springframework.boot","spring-boot-starter-web")
	implementation("org.springframework.boot","spring-boot-starter-security")
	implementation("org.springframework.cloud","spring-cloud-starter-kubernetes-all")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude ("org.junit.vintage","junit-vintage-engine")
	}
}

dependencyManagement {
	imports {
		mavenBom ("de.codecentric:spring-boot-admin-dependencies:2.2.1")
		mavenBom ("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR1")
	}
}

tasks.withType<Test>{
	useJUnitPlatform()
}

docker {
	springBootApplication {
		baseImage.set("openjdk:13-alpine")
		ports.set(listOf(9003, 9003))
		images.set(setOf("kubeadminserver:0.0.1", "kubeadminserver:latest"))
		jvmArgs.set(listOf("-Xmx2048m"))
	}
}

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_1_8
}