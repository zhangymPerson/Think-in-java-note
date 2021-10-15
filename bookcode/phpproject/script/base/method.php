<?php

//测试函数

//函数定义前就可以访问
testOne();

function testOne() {
    echo "testOne" . PHP_EOL;
}

testOne();

// 函数中的函数
function testTwo() {
    echo "testTwo" . PHP_EOL;
    function innerMethod() {
        echo "innerMethod" . PHP_EOL;
    }
}

//直接调用报错
// innerMethod();
//初始化函数后
testTwo();
innerMethod();

// 函数中的参数读取
function testThree() {
    echo "testThree" . PHP_EOL;
}

// 没有参数也可以传参
testThree("a", "b");


function testFore($one, $two) {
    echo "test params" . PHP_EOL;
}
// 有参数不传会报错
// testFore();
// testFore("a");
testFore("a", "b");

function testFive($one = 0, $two) {
    echo "testFive" . PHP_EOL;
}

// testFive();
// testFive("a"); 前面参数自定义也没法省略
testFive("a", "b");

function testSix($one, $two = 0) {
    echo "testSix" . PHP_EOL;
}
//后面参数自定义则可以省略
testSix("a");
testSix("a", "b");


//函数参数获取 动态获取
function testSeven() {
    error_log("====执行到:" . __METHOD__ . ":" . __LINE__ . "====");
    $numargs = func_num_args();
    echo "参数个数为: $numargs" . PHP_EOL;
    $args = func_get_args();
    if ($numargs >= 2) {
        echo "第二个参数为: " . func_get_arg(1) . PHP_EOL;
        echo "第二个参数为: " . $args[1] . PHP_EOL;
    }
}
testSeven('a', 'b', 'c');
