var One = function(){
    console.log("one.js中的函数")
}

var one = "one.js中的变量var"
var a = "one.js中的变量 a "
var b = "one.js中的变量 b"
var c = "one.js中的变量 c"
var d = "one.js中的变量 d"

const oneConst = "one.js中的oneConst"

// 从模块的引用中导出。
module.exports.a = a; 

module.exports.One=One

// 不导出，仅在模块中可用。
exports = { b: false };  