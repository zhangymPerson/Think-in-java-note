//gradle 主要两个对象 project和task

//kotlin语言编写的gradle脚本文件命名方式

//project 提供容器和上下文

//task案例


// task 扫描时运行/运行时运行两种
//构建是执行
task("taskname", {
    //任务内容
    //构建时会先扫描并执行所有task内容
    println("test task")
})

//doFirst{} 在运行任务时才会执行当前脚本
task("runtask", {
    doFirst { print("运行时才执行的task,扫描的时候不执行") }
})

//任务依赖

// a - > b -> c 执行顺序

//a
task("a", {
    doFirst {
        println("one : a task")
    }
})

//b
task("b", {
    doFirst {
        println("two : b task")
    }
    //dependsOn(taskname) 通过调用这个函数来实现任务的依赖关系
}).dependsOn("a")

//c
task("c", {
    doFirst {
        println("three : c task")
    }
}).dependsOn("b")


//增量式更新
//插件 常用
// application 编译应用程序 java/kotlin
// java 编译Java程序
// war web项目
plugins {
    java
}

//获取文件名
task("filename", {
    var src = fileTree("src")
    var info = file("file.log")
    src.forEach {
        if (it.isFile) {
            info.appendText(it.absolutePath)
            info.appendText("\n")
        }
    }
})