plugins{
    java
}

group = "com.kish.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}