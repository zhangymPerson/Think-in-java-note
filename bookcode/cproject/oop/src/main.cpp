#include <iostream>
#include "bean/person.h"

using namespace danao;

int main(int argc, char const *argv[])
{
    std::cout << "hello word" << std::endl;
    // 定义一个对象
    // 等价于 java 中 Person p = new Person();
    danao::Person p;
    p.setAge(1);
    p.setId(1);
    p.setName("zhangsan");
    std::cout << p.toString();

    Person p1 = Person(2, "lisi", 2);
    std::cout << p1.toString() << std::endl;
    std::system("pause");
    return 0;
}
