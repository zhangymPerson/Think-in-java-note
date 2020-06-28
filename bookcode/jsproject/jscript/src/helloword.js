const { One } = require("./one");

//脚本执行
console.log("one Hello Word");

/**
 * 函数执行
 */
function f() {
   console.log("two Hello Word");
}
//函数调用
f();

//nodejs的文件导入
const one = require('./one.js');
console.log("one.js导入")
//调用其他文件
console.log(one)
one.One

const two = require("./two.js")
console.log("two.js导入")
console.log(two)
two.print()
two.copy()

const three = require("./three.js")
console.log("three.js导入")
console.log(three)

const fore = require("./fore.js")
console.log("fore.js导入")
console.log(fore)

const Person = require("./Person.js")
console.log("Person.js导入")
console.log(Person)
// console.log(Person.printFunc())
console.log(Person.func())