<?php

/**
 * 字符串为空判断
 */
class CompareTest {
    public function __construct() {
    }

    /**
     * 测试字符串比较
     */
    public function compareStr() {
        $a = "list";
        $b = 'list';
        $c = "List";
        $d = "LIST";
        echo $a == $b . PHP_EOL;
        if ($a == $b) {
            echo "\$a = \$b";
        } else {
            echo "$a != $b";
        }
    }

    public function isEmpty(string $var = null) {
        # code...
        if (empty($var)) {
            echo "$var 为空" . PHP_EOL;
        } else {
            echo "$var 不为空" . PHP_EOL;
        }
    }
}

$obj = new CompareTest();
$obj->compareStr();
$obj->isEmpty("a");
$obj->isEmpty();
$obj->isEmpty("");
$obj->isEmpty("  ");
