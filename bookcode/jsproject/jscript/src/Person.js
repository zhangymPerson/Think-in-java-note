function Person(id, name, sex) {
    this.id = id;
    this.name = name;
    this.sex = sex;
}

//javascript里面有一句话，函数即对象，Person 是对象，module.export =Person, 
//即相当于导出整个Person对象。外面模块调用它的时候，能够调用Person的所有方法。
//不过需要注意，只有是Person的静态方法的时候，才能够被调用，prototype创建的方法，则属于Person的私有方法。
module.exports = Person;

Person.prototype.prototypeFunc = function () {
    console.log('Person的私有方法，export之后外部无法调用')
}

Person.func = function () {
    console.log('Person的方法')
}