plugins {
    // We want to build Java code
    id("java")
    // We want to be able to run our Main class easily with gradlew run
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

// Set the Java compatibility (e.g., Java 11)
java.sourceCompatibility = JavaVersion.VERSION_11

// Let Gradle know which class contains the main method
application {
    // Notice the use of set(...) in Kotlin
    mainClass.set("org.example.Main")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}