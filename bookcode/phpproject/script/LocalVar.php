<?php

echo "hello word!";

//__NAMESPACE__     '返回当前所在命名空间'
//__CLASS__		'返回当前类名'
//__METHOD__    '返回当前类名加方法名      A::b'
//__FUNCTION__   '返回当前方法名    b'
//__TRAIT__        '返回当前映射类'
//__LINE__          '返回当前行号'
//__FILE__          '返回当前文件所在路径'
//__DIR__           '返回当前文件所在目录的路径'

function test() {
    echo "__FUNCTION__ = " . __FUNCTION__ . PHP_EOL;
}

class Test {
    public function test() {
        echo "__CLASS__ = " . __CLASS__ . PHP_EOL;
        echo "__METHOD__ = " . __METHOD__ . PHP_EOL;
    }
}

echo "__NAMESPACE__ = " . __NAMESPACE__ . PHP_EOL;
echo "__CLASS__ = " . __CLASS__ . PHP_EOL;
echo "__METHOD__ = " . __METHOD__ . PHP_EOL;
echo "__DIR__ = " . __DIR__ . PHP_EOL;
echo "__FUNCTION__ = " . __FUNCTION__ . PHP_EOL;
echo "__LINE__ = " . __LINE__ . PHP_EOL;
echo "__DIR__ = " . __DIR__ . PHP_EOL;
echo "__FILE__ = " . __FILE__ . PHP_EOL;
test();
echo
$t =  new Test;
$t->test();
