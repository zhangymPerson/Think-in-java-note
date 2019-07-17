# 一切皆对象

## 对象存储位置

## 特列

### 基本类型

|基本类型|大小|最小值|最大值|包装器类型|默认值|
|-|-|-|-|-|-|
|boolean||||boolean|false
|char|16bit|||Character|'\u000'(null)
|byte|8bit|||Byte|(byte)0
|short|16bit|||Short|(short)0
|int|32bit|||Integer|0
|long|64bit|||Long|0L
|double|64bit|||Double|0.0d
|flout|32bit|||Flout|0.0f
|void||||Void|

### 高精度数字

BigInteger 和 BigDecimal
没有对应的基本类型 可理解为包装类

### Java中的对象不需要销毁，有GC

- 作用域 scope

    变量名的可见性和生命周期
    ```java
    {
        //i的生命周期只在括号内
        int i = 1;
    }
    ```

## java 中的名字可见性

- 命名

    域名反写，如 cn.alibaba.taobao 作为包名

- 其他模块引入

    import 关键字 

    如果使用*，可以引入一个包

- static关键字

    见code

