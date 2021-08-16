#include <iostream>
//定义结构体
struct Student
{
    /* data */
    std::string name;
    int age;
    int score;
    //结构体定义完必须加 ";" 结尾
};

struct Teacher
{
    std::string name;
    int age;
    // 结构体嵌套
    struct Student stu[10];
};