buildscript {
    repositories {
        // Add here whatever repositories you're already using
        mavenCentral()
    }

    dependencies {
        classpath("ch.epfl.scala:gradle-bloop_2.13:1.6.2") // suffix is always 2.12, weird
    }
}

plugins {

    id("ai.acyclic.scala3-conventions")
    id("ai.acyclic.publish-conventions")
}

idea {

    module {

        excludeDirs = excludeDirs + listOf(

//            file("lightweight-dependency")
        )
    }
}