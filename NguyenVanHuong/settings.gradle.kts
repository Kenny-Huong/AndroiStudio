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

rootProject.name = "NguyenVanHuong"
include(":app")
include(":myapplication9th7")
include(":app:baitap10th7")
include(":baitap10th9")
include(":listview_11th7")
include(":nguyenvanhuong_bt12th7n24")
include(":nguyenvanhuong_menu")
include(":nguyenvanhuong_listview2")
include(":btvn16th7")
include(":nguuyenvanhuong_bt18th7")
include(":nguyenvanhuong_bt19th7")
include(":nguyenvanhuong_bt21th7")
include(":danhsachdienthoai")
include(":nguyenvanhuong_bt23th7")
include(":nguyenvanhuong_bt25th7")
include(":nguyenvanhuong_bt26th7")
