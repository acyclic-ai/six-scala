//val versions = gradle.rootProject.versions()

include("six")
project(":six").projectDir = file("module")

include(
    ":six:typetag",
    ":six:unused",
    ":six:iskra",
    ":six:spark"
)

pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
    // maven("https://dl.bintray.com/kotlin/kotlin-dev")
}
