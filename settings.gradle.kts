//val versions = gradle.rootProject.versions()

include(":typetag")
include(":unused")

pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
    // maven("https://dl.bintray.com/kotlin/kotlin-dev")
}
