//获取数据类型的方式
var a = 123,
    b = true,
    c = "123",
    d = undefined,
    e = null;
var o = new Object();
var f = new Function();
var f1 = function(){};
function f2(){}
var arr = [];
var arr1 = new Array();
var reg = new RegExp();　　

//类型查看
console.log("a:"+typeof(a));
console.log("b:"+typeof(b));
console.log("c:"+typeof(c));
console.log("d:"+typeof(d));
console.log("e:"+typeof(e));
console.log("o:"+typeof(o));
console.log("f:"+typeof(f));
console.log("f1:"+typeof(f1));
console.log("f2:"+typeof(f2));
console.log("arr:"+typeof(arr));
console.log("arr1:"+typeof(arr1));
console.log("reg:"+typeof(reg));　

// a:number
// b:boolean  
// c:string   
// d:undefined
// e:object   
// o:object   
// f:function 
// f1:function
// f2:function
// arr:object
// arr1:object
// reg:object

//类型判断
console.log(a instanceof Number);
console.log(b instanceof Boolean);
console.log(c instanceof String);
// console.log("d:"+d instanceof undefined);
// console.log("e:"+e instanceof Null);
console.log(o instanceof Object);
console.log(f instanceof Function);
console.log(f1 instanceof Function);
console.log(f2 instanceof Function);
console.log(arr instanceof Array);
console.log(arr1 instanceof Array);
console.log(reg instanceof RegExp);　　

// false
// false
// false
// true
// true
// true
// true
// true
// true
// true