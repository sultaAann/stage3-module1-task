plugins {
    id("java")
}

group = "com.mjc.school"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(mapOf("path" to ":module-repository")))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
}

tasks.test {
    useJUnitPlatform()
}