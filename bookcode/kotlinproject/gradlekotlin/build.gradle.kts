//gradle 主要两个对象 project和task

//kotlin语言编写的gradle脚本文件命名方式

//project 提供容器和上下文

//task案例

task("taskname", {
    //任务内容
    //构建时会先扫描并执行所有task内容
    println("test task")
})

task("runtask", {
    doFirst { print("运行时才执行的task,扫描的时候不执行") }
})