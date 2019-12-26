plugins {
    id("org.springframework.boot") version ("2.2.2.RELEASE")
    id("io.spring.dependency-management") version ("1.0.8.RELEASE")
    id("com.bmuschko.docker-spring-boot-application") version "6.1.1"
    java
}

group = "com.kish.learning"
version = "0.0.1-SNAPSHOT"


repositories {
    mavenCentral()
}


dependencies {
    implementation("org.springframework.boot","spring-boot-starter-actuator")
    implementation ("org.springframework.boot","spring-boot-starter-web")
    compileOnly("org.projectlombok","lombok")
    annotationProcessor("org.projectlombok","lombok")
    testImplementation("org.springframework.boot","spring-boot-starter-test") {
        exclude("org.junit.vintage","junit-vintage-engine")
    }
}


tasks.withType<Test> {
    useJUnitPlatform ()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

/*tasks.create("createDockerfile", com.bmuschko.gradle.docker.tasks.image.Dockerfile::class) {
    from("openjdk:11-alpine")
    copyFile("my-app-1.0.jar", "/app/my-app-1.0.jar")
    entryPoint("java")
    defaultCommand("-jar", "/app/my-app-1.0.jar")
    exposePort(8080)
}*/

docker {
    springBootApplication {
        baseImage.set("openjdk:13-alpine")
        ports.set(listOf(9090, 9090))
        images.set(setOf("kubeservice:0.0.2", "kubeservice:latest"))
        jvmArgs.set(listOf("-Xmx2048m"))
    }
}


