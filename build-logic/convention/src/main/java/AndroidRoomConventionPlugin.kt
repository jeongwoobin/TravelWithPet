import androidx.room.gradle.RoomExtension
import com.foxydev97.travelwithpet.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }


            dependencies {
                add("ksp", libs.findLibrary("androidx.room.compiler").get())
                add("implementation", libs.findLibrary("androidx.room.ktx").get())
                add("implementation", libs.findLibrary("androidx.room.runtime").get())
                add("annotationProcessor", libs.findLibrary("androidx.room.runtime").get())
            }
        }
    }
}