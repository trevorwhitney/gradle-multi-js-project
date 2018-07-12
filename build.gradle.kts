task("build") {
    println("Building the parent multi-project")
    println("Configurations: ${project.configurations.forEach { println(it) }}")
}

project(":components") {
    dependencies {
        js(project(":types"))
    }
}