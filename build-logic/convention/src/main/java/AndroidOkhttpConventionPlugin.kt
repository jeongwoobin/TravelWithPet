import com.foxydev97.travelwithpet.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidOkhttpConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
//            pluginManager.run {
//            }

            dependencies {
                add("implementation", platform(project.libs.findLibrary("okhttp.bom").get()))
                add("implementation", project.libs.findLibrary("okhttp.logging.interceptor").get())
            }
        }
    }
}