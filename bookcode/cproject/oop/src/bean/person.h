#pragma once
#include <iostream>
// .h文件中主要负责类属性和方法/函数的声明
// .cpp文件中实现相关声明
namespace danao
{
    class Person
    {
    private:
        /* data */
        //年龄
        int age;
        //姓名
        std::string name;
        //编号
        int id;

    public:
        // 构造函数
        Person();
        Person(int age, std::string name, int id);

        void setAge(int age);
        int getAge();

        void setName(std::string name);
        std::string getName();

        void setId(int id);
        int getId();

        std::string toString();

        ~Person();
    };

    // Person::Person(/* args */)
    // {
    // }

    // Person::~Person()
    // {
    // }

}