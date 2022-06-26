pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven("https://jitpack.io")
    }
}
rootProject.name = "Habits"
include (":app")
include(":common-ui")
include(":common-data")
include(":feature-splash")
include(":feature-onboarding")
include(":feature-home")
include(":data")
