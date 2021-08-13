#include <iostream>
#include "dog.h"
namespace bean
{

    // void Dog() = default;
    void Dog()
    {
        std::cout << "A dog has been constructed\n";
    }

    // 对象（例如字符串）应当以引用的形式传递，
    // 对于不需要修改的对象，最好使用常量引用。
    void Dog::setName(const std::string &dogsName)
    {
        name = dogsName;
    }

    void Dog::setWeight(int dogsWeight)
    {
        weight = dogsWeight;
    }

    // 虚函数的virtual关键字只需要在声明时使用，不需要在定义时重复
    void Dog::print() const
    {
        std::cout << "Dog is " << name << " and weighs " << weight << "kg\n";
    }

    Dog::~Dog()
    {
        std::cout << "Goodbye " << name << "\n";
    }
}