plugins {
    id("java")
}

group = "com.mjc.school"
version = "all"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(mapOf("path" to ":module-service")))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}