console.log("查询");

const fs = require("fs");

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('你如何看待 Node.js 中文网？', (answer) => {
    // TODO：将答案记录在数据库中。
    console.log(`感谢您的宝贵意见：${answer}`);

    rl.close();
});

// // 异步读取
// fs.readFile('input.txt', function (err, data) {
//     if (err) {
//         return console.error(err);
//     }
//     console.log("异步读取: " + data.toString());
// });

// // 同步读取
// var data = fs.readFileSync('input.txt');
// console.log("同步读取: " + data.toString());

// console.log("程序执行完毕。");
