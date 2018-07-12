dependencies {
    js(project(":types"))
}

tasks["buildJs"].doLast {
    println("Building the components component. This should come last.")
}
