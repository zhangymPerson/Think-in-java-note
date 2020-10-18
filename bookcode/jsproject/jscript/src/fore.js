exports.a = function () {
    console.log('a')
}
//exports在module.exports 被改变后，失效。
module.exports = {
    a: 2
}
//不能覆盖module.exports中的值
exports.a = 1