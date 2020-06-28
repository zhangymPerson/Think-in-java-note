//导出单个函数
module.exports.twoPrint = function twoPrint() {
    console.log("调用了two.js的print方法");
}

//导出函数被别的文件引用
module.exports = {
    print: function () {
        console.log("调用了two.js的print方法");
    },
    copy: function (a, b) {
        console.log("我是two.js的copy方法");
    }
}