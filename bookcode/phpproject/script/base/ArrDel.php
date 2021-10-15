<?php

$arr = array('1', '2', '3');

$brr = array(
    'a' => '1',
    'b' => '2',
    'c' => '3',
    'd' => array("aaa" => "ccc", "bbb" => "ddd"),
);


foreach ($brr as $key => &$value) {
    if ($value == "2") {
        unset($brr[$key]);
    }
}

// echo json_encode($brr);


function arrAdd() {
    $arr = array('one', "two", "three", "fore");
    echo json_encode($arr);
    //php添加元素
    $arr[] = "five";
    echo json_encode($arr);
}

arrAdd();
