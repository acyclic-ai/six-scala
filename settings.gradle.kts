//val versions = gradle.rootProject.versions()

include("six")
project(":six").projectDir = file("module")

include(
    ":six:spike",
//    ":six:typetag",
//    ":six:graph",
//    ":six:unused",
//    ":six:spark"
)

pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
    // maven("https://dl.bintray.com/kotlin/kotlin-dev")
}
