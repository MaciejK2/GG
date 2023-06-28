import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version ("1.8.0")
    id("com.github.weave-mc.weave") version ("8b70bcc707")
}

group = "me.zircta"
version = "2.0"

minecraft.version("1.8.9")

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    testImplementation(kotlin("test"))

    compileOnly("com.github.Weave-MC:Weave-Loader:v0.2.3")
    compileOnly("org.spongepowered:mixin:0.8.5")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.jar {
    val wantedJar = listOf<String>()
    configurations["compileClasspath"]
        .filter { wantedJar.find { wantedJarName -> it.name.contains(wantedJarName) } != null }
        .forEach { file: File ->
            from(zipTree(file.absoluteFile)) {
                this.duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            }
        }
}