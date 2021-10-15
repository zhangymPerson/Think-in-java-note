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


// PHP构造方法使用
// 多个构造php本身不支持 需要自己实现
class Test {
    function __construct() {
        echo 'Test类无参构造方法被调用<br/>';
        $a = func_get_args();
        $i = func_num_args();
        //判断Test类是否有__constructxx方法,将方法名记为$f
        if (method_exists($this, $f = '__construct' . $i)) {
            //若存在xx方法，使用call_user_func_array(arr1,arr2)函数调用他,该函数的参数为两个数组，前面的数组为调用谁($this)的什么($f)方法，后一个数组为参数
            call_user_func_array(array($this, $f), $a);
        }
    }
    function __construct1($a1) {
        echo 'Test类1个参数的仿构造方法被调用<br/>';
        //输出参数值
        echo '其值为：' . $a1 . '<br/><br/>';
    }
    function __construct2($a1, $a2) {
        echo 'Test类2个参数的仿构造方法被调用<br/>';
        echo '其值为：' . $a1 . '、' . $a2 . '<br/><br/>';
    }
    function __construct3($a1, $a2, $a3) {
        echo 'Test类3个参数的仿构造方法被调用<br/>';
        echo '其值为：' . $a1 . '、' . $a2 . '、' . $a3 . '<br/><br/>';
    }
}
//测试
new Test('你');
new Test('你', '好');
new Test('你', '好', '啊');
