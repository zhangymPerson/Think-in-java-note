//ts文件

function hello(){
    console.log("hello word!")
}

hello();
//类
class Person{
    //属性 默认是
    username:string;
    //
    age:number;

    static sex:string = "男";
    //构造
    constructor(username:string,age:number){
        this.username=username;
        this.age=age;
    }
    //成员方法
    run():string{
        return `${this.username} 在跑步 - 成员方法`;
    }

    static runs():string{
        // return `${this.username} 在跑步 - 静态方法`
        //必须调用静态成员
        return `Person 性别 ：${this.sex}`
    }
}

let p = new Person("测试",23);
console.log(p.run());
console.log(Person.runs());