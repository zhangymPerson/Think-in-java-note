<?php

/**
 * 定义接口测试
 */
interface InterfaceOne
{
    public function doSomething();
}

interface InterfaceTwo
{
    public function doSomethingElse();
}

// 接口可以被扩展
interface InterfaceThree extends InterfaceTwo
{
    public function doAnotherContract();
}

abstract class MyAbstractClass implements InterfaceOne
{
    public $x = 'doSomething';
}

class MyConcreteClass extends MyAbstractClass implements InterfaceTwo
{
    public function doSomething()
    {
        echo $this->x . PHP_EOL;
    }

    public function doSomethingElse()
    {
        echo 'doSomethingElse' . PHP_EOL;
    }
}

echo "start" . PHP_EOL;
$obj = new MyConcreteClass();
$obj->doSomething();
$obj->doSomethingElse();
echo "end" . PHP_EOL;
