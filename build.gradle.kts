plugins {
    id("base")
}

allprojects {
    val js by configurations.creating

    apply {
        plugin("base")
    }
}

subprojects {
    task("buildJs") {
        tasks["assemble"].dependsOn(this)
    }
}

allprojects {
    afterEvaluate {
        val dependencies: List<Dependency> = project.configurations
            .flatMap { it.allDependencies }
            .filter { it is ProjectDependency }

        dependencies.forEach {
            project.tasks["buildJs"].dependsOn(":${it.name}:buildJs")
        }
    }
}