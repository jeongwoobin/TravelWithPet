import com.android.build.api.dsl.LibraryExtension
import com.foxydev97.travelwithpet.convention.ExtensionType
import com.foxydev97.travelwithpet.convention.configureBuildTypes
import com.foxydev97.travelwithpet.convention.configureKotlinAndroid
import com.foxydev97.travelwithpet.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            dependencies {
                add("implementation", project.libs.findLibrary("kotlinx.serialization.json").get())
//                add("implementation", project.libs.findLibrary("logger").get())
            }
        }
    }
}