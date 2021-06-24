<?php

/********************************
 * 函数
 */

// 通过"function"定义函数:
function my_function()
{
    return 'Hello';
}

echo my_function() . PHP_EOL;

// 函数名需要以字母或者下划线开头, 
// 后面可以跟着任意的字母、下划线、数字.

function add($x, $y = 1)
{ // $y 是可选参数，默认值为 1
    $result = $x + $y;
    return $result;
}

echo add(4) . PHP_EOL; // => 5
echo add(4, 2) . PHP_EOL; // => 6




// $result 在函数外部不可访问
// print $result; // 抛出警告

// 从 PHP 5.3 起我们可以定义匿名函数
$inc = function ($x) {
    return $x + 1;
};

echo $inc(2) . PHP_EOL; // => 3

function foo($x, $y, $z)
{
    echo "$x - $y - $z";
}

// 函数也可以返回一个函数
function bar($x, $y)
{
    // 用 'use' 将外部的参数引入到里面
    return function ($z) use ($x, $y) {
        foo($x, $y, $z);
    };
}

$bar = bar('A', 'B');
echo gettype($bar) . PHP_EOL;
// 输出 "A - B - C"
$bar('C'); 

// 你也可以通过字符串调用函数
$function_name = 'add';
echo $function_name(1, 2) . PHP_EOL; // => 3
// 在通过程序来决定调用哪个函数时很有用
// 或者，使用 call_user_func(callable $callback [, $parameter [, ... ]]);
