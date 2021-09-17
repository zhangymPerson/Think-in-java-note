<?php

$arr = array('1', '2', '3');
$brr = array(
    'a' => '1',
    'b' => '2',
    'c' => '3',
    'd' => array("aaa" => "ccc", "bbb" => "ddd"),
);

foreach ($brr as $key => &$value) {
    var_dump($key . '=' . $value);
    if ($value == "2") {
        unset($brr[$key]);
    }
    $value['a'] = "b";
    //    $arrOne['a'] = "b";
}
echo json_encode($brr);
