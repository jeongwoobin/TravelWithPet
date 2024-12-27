package com.foxydev97.travelwithpet.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
        }

        dependencies {
            val bom = libs.findLibrary("androidx.compose.bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
//            add("debugImplementation", libs.findLibrary("androidx.ui.tooling.preview").get())

//            add("implementation", project.libs.findBundle("compose").get())
//            add("implementation", project.libs.findBundle("compose.debug").get())
//            add("debugImplementation", project.libs.findBundle("compose.debug").get())
//            add("androidTestImplementation", project.libs.findLibrary("androidx.ui.test.junit4").get())

        }
    }
}