<?php
set_time_limit(0);
ini_set('memory_limit', '2048M');
error_reporting(E_ALL ^ E_NOTICE ^ E_DEPRECATED ^ E_STRICT);
ini_set('display_errors', 1);

/**
 * 功能 导入图搜垂类[手抄报&简笔画]离线资源
 *
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
    public function __construct1($var) {
        //构造时执行
        echo "构造函数" . $var . PHP_EOL;
    }


    /**
     * @return null
     */
    public function doTask() {
        echo "自定义任务" . PHP_EOL;
    }



    /**
     *  析构函数
     */
    public function __destruct() {
        echo "析构方法" . PHP_EOL;
    }
}

// inter
$task = new TaskName();
$task = new TaskName("a");
$task->doTask();
