#include <iostream>
#include "student.h"

using namespace std;

// 结构体测试
void testStu()
{
    // 结构体创建
    struct Student stu;
    stu.name = "zhangsan";
    stu.age = 12;
    stu.score = 14;

    //指针访问
    Student *stuP = &stu;

    cout << "指针引用取值" << stuP->age << endl;
    cout << "指针引用取值" << stuP->name << endl;

    struct Student stuOne = {
        "李四", 12, 34};

    cout << stu.name << stu.age << stu.score << endl;
    cout << stuOne.name << stuOne.age << stuOne.score << endl;

    struct Student stuArr[] =
        {
            {"one", 12, 21},
            {"two", 22, 22},
            {"three", 33, 33}};

    cout << stuArr[1].age << endl;

    struct Student stuArrOne[1];
    stuArrOne[0].name = "aa";
    stuArrOne[0].age = 12;
    cout << sizeof(stuArrOne) << endl;
}

int main(int argc, char const *argv[])
{
    cout << "hello word" << endl;
    testStu();
    return 0;
}
