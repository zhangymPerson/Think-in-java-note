"use strict";
//ts文件
function hello() {
    console.log("hello word!");
}
hello();
//类
var Person = /** @class */ (function () {
    //构造
    function Person(username, age) {
        this.username = username;
        this.age = age;
    }
    //成员方法
    Person.prototype.run = function () {
        return this.username + " \u5728\u8DD1\u6B65 - \u6210\u5458\u65B9\u6CD5";
    };
    Person.runs = function () {
        // return `${this.username} 在跑步 - 静态方法`
        //必须调用静态成员
        return "Person \u6027\u522B \uFF1A" + this.sex;
    };
    Person.sex = "男";
    return Person;
}());
var p = new Person("测试", 23);
console.log(p.run());
console.log(Person.runs());
