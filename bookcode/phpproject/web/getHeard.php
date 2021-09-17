<?php

class test {

    
    /**
     * 打印所有的heard头
     */
    public function getallheaders() {
        $headers = [];
        foreach ($_SERVER as $name => $value) {
            if (substr($name, 0, 5) == 'HTTP_') {
                $headers[str_replace(' ', '-', ucwords(strtolower(str_replace('_', ' ', substr($name, 5)))))] = $value;
            }
        }
        file_put_contents(__DIR__ . "/debug.log", " result \n" . var_export($headers, true) . "\n", FILE_APPEND);
        return $headers;
    }
}
