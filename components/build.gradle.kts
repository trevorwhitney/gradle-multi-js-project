//val js by configurations.creating
//
//evaluationDependsOn(":types")

task("build") {
    doLast {
        println("Building the components component of frontend")
    }
}

//dependencies {
//    js(project(":types"))
//}