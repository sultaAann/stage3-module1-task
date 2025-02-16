plugins {
    id("java")
}

group = "com.mjc.school"
version = "all"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
}

tasks.test {
    useJUnitPlatform()
}