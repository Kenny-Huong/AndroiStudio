pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "09-NguyenVanHuong_LTĐNT_21103100115_2003"
include(":app")
include(":de3")
include(":de4")
include(":de7")
include(":de10")
include(":de16")
include(":de11")
include(":de13")
include(":de14")
include(":de8")
