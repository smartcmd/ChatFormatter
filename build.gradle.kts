plugins {
    id("java-library")
    id("org.allaymc.gradle.plugin") version "0.2.0"
}

group = "me.daoge.chatformatter"
description = "A simple chat formatter plugin for Allay"
version = "0.1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

allay {
    api = "0.17.0"

    plugin {
        entrance = ".ChatFormatter"
        authors += "daoge_cmd"
        website = "https://github.com/smartcmd/ChatFormatter"
        dependency("PlaceholderAPI")
    }
}

repositories {
    maven("https://storehouse.okaeri.eu/repository/maven-public/")
}

dependencies {
    compileOnly(group = "org.allaymc", name = "papi", version = "0.1.1")
    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.34")
    implementation(group = "eu.okaeri", name = "okaeri-configs-yaml-snakeyaml", version = "5.0.13")
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.34")
}
