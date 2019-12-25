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

ext {
    set("springCloudVersion", "Hoxton.SR1")
}

dependencies {
    implementation("org.springframework.boot","spring-boot-starter-web")
    implementation("org.springframework.cloud","spring-cloud-starter")
    implementation( "org.springframework.cloud","spring-cloud-starter-loadbalancer")
    compileOnly ("org.projectlombok","lombok")
    annotationProcessor ("org.projectlombok","lombok")
    testImplementation("org.springframework.boot","spring-boot-starter-test") {
        exclude ("org.junit.vintage","junit-vintage-engine")
    }
}

dependencyManagement {
    imports {
        mavenBom ("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR1")
    }
}

tasks.withType<Test> {
    useJUnitPlatform ()
}


docker {
    springBootApplication {
        baseImage.set("openjdk:13-alpine")
        ports.set(listOf(9090, 9090))
        images.set(setOf("kubeclientsvc:0.0.2", "kubeclientsvc:latest"))
        jvmArgs.set(listOf("-Xmx2048m"))
    }
}