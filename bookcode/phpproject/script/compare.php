<?php

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
        }else{
            echo "$a != $b";
        }
    }
}

$obj = new CompareTest();
$obj->compareStr();
