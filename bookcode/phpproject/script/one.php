<?php
// Show all errors
//打印所有错误日志
error_reporting(E_ALL);
//编写测试代码
print("hello word\n");
// () 对于echo和print是可选的
// (每个语句必须以分号结尾)
echo "World\n"; // 输出 "World" 并且换行

echo PHP_EOL;
echo PHP_EOL;


/************************************
 * 类型与变量
 */

// 变量以$开始
// 变量可以以字母或者下划线开头，后面可以跟着数字、字母和下划线

// 布尔值是大小写无关的
$boolean = true;  // 或 TRUE 或 True
$boolean = false; // 或 FALSE 或 False

// 整型
$int1 = 12;   // => 12
$int2 = -12;  // => -12
$int3 = 012;  // => 10 (0开头代表八进制数)
$int4 = 0x0F; // => 15 (0x开头代表十六进制数)

// 浮点型 (即双精度浮点型)
$float = 1.234;
$float = 1.2e3;
$float = 7E-10;

// 算数运算
$sum = 1 + 1; // 2
$difference = 2 - 1; // 1
$product = 2 * 2; // 4
$quotient = 2 / 1; // 2

// 算数运算的简写
$number = 0;
$number += 1;      // $number 自增1
echo $number++ . PHP_EOL;    // 输出1 (运算后自增)
echo ++$number . PHP_EOL;    // 输出3 (自增后运算)
$number /= $float; // 先除后赋值给 $number

// 字符串需要被包含在单引号之中
$sgl_quotes = '$String'; // => '$String'

// 如果需要在字符串中引用变量，就需要使用双引号
$dbl_quotes = "This is a $sgl_quotes."; // => 'This is a $String.'

// 特殊字符只有在双引号中有用
$escaped = "This contains a \t tab character.";
$unescaped = 'This just contains a slash and a t: \t';

// 可以把变量包含在一对大括号中
$money = "I have $${number} in the bank.";

// 自 PHP 5.3 开始, nowdocs 可以被用作多行非计算型字符串
$nowdoc = <<<'END'
Multi line
string
END;

// 而Heredocs则可以用作多行计算型字符串
$heredoc = <<<END
Multi line
$sgl_quotes
END;

// 字符串需要用 . 来连接
echo 'This string ' . 'is concatenated' . PHP_EOL;

echo PHP_EOL;
echo PHP_EOL;

/********************************
 * 数组
 */

// PHP 中的数组都是关联型数组，也就是某些语言中的哈希表或字典

// 在所有PHP版本中均适用：
$associative = array('One' => 1, 'Two' => 2, 'Three' => 3);

// PHP 5.4 中引入了新的语法
$associative = ['One' => 1, 'Two' => 2, 'Three' => 3];

echo $associative['One'] . PHP_EOL; // 输出 1

// 声明为列表实际上是给每个值都分配了一个整数键（key）
$array = ['One', 'Two', 'Three'];
echo $array[0] . PHP_EOL; // => "One"


/********************************
 * 逻辑
 */
$a = 0;
$b = '0';
$c = '1';
$d = '1';

// 如果assert的参数为假，就会抛出警告

// 下面的比较都为真，不管它们的类型是否匹配
echo assert($a == $b); // 相等
echo assert($c != $a); // 不等
echo assert($c <> $a); // 另一种不等的表示
echo assert($a < $c);
echo assert($c > $b);
echo assert($a <= $b);
echo assert($c >= $d);

// 下面的比较只有在类型相同、值相同的情况下才为真
echo assert($c === $d);
echo assert($a !== $d);
// echo assert(1 === '1');
echo assert(1 !== '1');
echo PHP_EOL;

//json
$arr = array('a' => 1, 'b' => 2, 'c' => 3, 'd' => 4, 'e' => 5);
$aStr = $arr["a"];
$bStr = $arr["b"];
echo $bStr . PHP_EOL;
echo $aStr . PHP_EOL;

for ($x = 0; $x < count($arr); $x++) {
    echo "arr = " . $arr[$x] . PHP_EOL;
}


$csName = array("Linux", "PHP", "MySQL", "HTML", "CSS", "JQuery");
//  方式一：for循环遍历

for ($i = 0; $i < count($csName); $i++) {
    echo $csName[$i] . PHP_EOL;
}
echo json_encode($arr);
echo PHP_EOL;
//关联数组
$age = array("Bill" => "63", "Steve" => "56", "Elon" => "47");

foreach ($age as $x => $x_value) {
    echo "Key=" . $x . ", Value=" . $x_value . PHP_EOL;
}


//php 时间格式化
$date = date('Y-m-d H:i:s', time());
print($date);