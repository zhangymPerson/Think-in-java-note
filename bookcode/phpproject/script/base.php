<?php
set_time_limit(0);
ini_set('memory_limit', '2048M');
error_reporting(E_ALL ^ E_NOTICE ^ E_DEPRECATED ^ E_STRICT);
ini_set('display_errors', 1);

/**
 * php 任务脚本模板
 * @author danao
 * @date   2021-10-15
 */

class TaskName {

    //成员变量
    private $varname;


    //conf 类型
    private $conf = [
        'dbhost' => '127.0.0.1',
        'dbuser' => 'root',
        'dbpwd'  => '123456',
        'dbname' => 'dbname',
        'dbport' => '3306',
    ];

    // map
    private $resourceTypeMap = [
        'key1'  => 1,
        'key2'  => 2,
    ];

    // 常量
    const CON_STSTUS = 1;

    /**
     *  构造函数
     */
    public function __construct() {
        //构造时执行
        echo "构造函数" . PHP_EOL;
    }
    /**
     * 不能有同名的构造函数
     */
    public function __construct1($var) {
        //构造时执行
        echo "构造函数" . $var . PHP_EOL;
    }


    /**
     * @return null
     */
    public function doTask() {
        echo "自定义任务" . PHP_EOL;
        $this->readFile();
    }

    /**
     * 读文件
     */
    public function readFile() {
        $fileName = "./README.md";
        $file = fopen($fileName, "r") or exit("无法打开文件!");
        // fgets() 函数用于从文件中逐行读取文件。
        // fgetc() 函数用于从文件中逐字符地读取文件。
        while (!feof($file)) {
            echo fgets($file);
        }
        fclose($file);
    }

    /**
     * 写文件
     */
    public function write($fileName, $data) {
        $file = fopen($fileName, "w");
        echo fwrite($file, $data);
        fclose($file);
    }

    /**
     *  析构函数
     */
    public function __destruct() {
        echo "析构方法" . PHP_EOL;
    }
}

//读取命令行输入
echo "接收到{$argc}个参数";
print_r($argv);

//方法2 传参方式 -a name -b age
$param_arr = getopt('a:b:');
print_r($param_arr);
//方法三

// inter
$task = new TaskName();
$task = new TaskName("a");
$task->doTask();
