//val versions = gradle.rootProject.versions()

include("six")
project(":six").projectDir = file("module")

include(
    ":six:typetag",
    ":six:unused"
)

pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
    // maven("https://dl.bintray.com/kotlin/kotlin-dev")
}
