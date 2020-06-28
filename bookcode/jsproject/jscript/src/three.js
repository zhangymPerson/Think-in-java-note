function Three() {
    console.log("three.js中的函数")
}

var three = "three.js中的变量var"

const threeConst = "three.js中的threeConst"

exports.a = function () {
    console.log('a')
}

//覆盖上面的 a 的 function
exports.a = 1