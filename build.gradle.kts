plugins {
    id("base")
}

allprojects {
    val js by configurations.creating

    apply {
        plugin("base")
    }

    afterEvaluate {
        val dependencies: List<Dependency> = project.configurations
            .getByName("js")
            .allDependencies
            .filter { it is ProjectDependency }

        dependencies.forEach {
            project.tasks["buildJs"].dependsOn(":${it.name}:buildJs")
        }
    }
}

subprojects {
    task("buildJs") {
        tasks["assemble"].dependsOn(this)
    }
}