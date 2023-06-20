pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CineScope"
include(":app")
include(":core:common")
include(":feature:onboard")
include(":core:data")
include(":core:domain")
include(":core:model")
include(":core:datastore")
include(":feature:navigator")
include(":feature:cinema")
include(":core:network")
include(":core:commonTest")
