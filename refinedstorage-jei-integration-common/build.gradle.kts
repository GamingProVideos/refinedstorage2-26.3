plugins {
    id("com.refinedmods.refinedarchitect.common")
}

version = "2.0.1-mc26.3-port.1"

repositories {
    maven {
        name = "Refined Storage"
        url = uri("https://maven.creeperhost.net")
        content {
            includeGroup("com.refinedmods.refinedstorage")
        }
    }
    maven {
        name = "JEI"
        url = uri("https://maven.blamejared.com/")
    }
}

refinedarchitect {
    common()
    publishing {
        maven = true
    }
}

base {
    archivesName.set("refinedstorage-jei-integration-common")
}

val refinedstorageQuartzArsenalVersion: String by project
val jeiVersion: String by project
val minecraftVersion: String by project

dependencies {
    api(project(":refinedstorage-common"))
    api("mezz.jei:jei-${minecraftVersion}-common-api:${jeiVersion}")
    api("mezz.jei:jei-${minecraftVersion}-common:${jeiVersion}")
    compileOnlyApi("com.refinedmods.refinedstorage:refinedstorage-quartz-arsenal-common:${refinedstorageQuartzArsenalVersion}")
}
