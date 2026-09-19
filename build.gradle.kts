import org.sonarqube.gradle.SonarExtension

plugins {
    id("com.refinedmods.refinedarchitect.root")
    id("com.refinedmods.refinedarchitect.base")
}

refinedarchitect {
    sonarQube("refinedmods_refinedstorage2", "refinedmods")
}

version = providers.gradleProperty("modVersion").get()

subprojects {
    group = "com.refinedmods.refinedstorage"

    plugins.withId("com.refinedmods.refinedarchitect") {
        version = providers.gradleProperty("modVersion").get()
    }
}

project.extensions.getByType<SonarExtension>().apply {
    properties {
        property(
            "sonar.coverage.exclusions",
            "refinedstorage-neoforge-api/**/*,refinedstorage-neoforge/**/*,refinedstorage-common/**/*,refinedstorage-common-api/**/*"
        )
        property(
            "sonar.exclusions",
            "refinedstorage-common/src/main/java/com/refinedmods/refinedstorage/common/repackage/**"
        )
    }
}
