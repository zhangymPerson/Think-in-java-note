<?php

class Person {
    const VALUE      = 'value'; // 常量

    static $staticVar   = 'static';

    // 属性必须声明其作用域
    public $property    = 'public';
    public $name;
    protected $prot = 'protected'; // 当前类和子类可访问
    private $priv   = 'private';   // 仅当前类可访问

    // 通过 __construct 来定义构造函数
    public function __construct($name) {
        // 通过 $this 访问当前对象
        $this->name = $name;
    }

    // 方法就是类中定义的函数
    public function myMethod() {
        print 'MyClass';
    }

    final function youCannotOverrideMe() {
    }

    public static function myStaticMethod() {
        print 'I am static';
    }
}

echo Person::VALUE . PHP_EOL;    // 输出 'value';
echo Person::$staticVar . PHP_EOL;  // 输出 'static';
Person::myStaticMethod(); // 输出 'I am static';

// 通过new来新建实例
$my_class = new Person('name');
// 如果不传递参数，那么括号可以省略

// 用 -> 来访问成员
echo $my_class->property . PHP_EOL;     // => "public"
echo $my_class->name .  PHP_EOL;
