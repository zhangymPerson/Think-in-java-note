///////////////////
// 类与面向对象编程
///////////////////

// 有关类的第一个示例
#include <iostream>

namespace bean
{

    // 声明一个类。
    // 类通常在头文件（.h或.hpp）中声明。
    class Dog
    {
        // 成员变量和成员函数默认情况下是私有（private）的。
        std::string name;
        int weight;

        // 在这个标签之后，所有声明都是公有（public）的，
        // 直到重新指定“private:”（私有继承）或“protected:”（保护继承）为止
    public:
        // 默认的构造器
        Dog();

        // 这里是成员函数声明的一个例子。
        // 可以注意到，我们在此处使用了std::string，而不是using namespace std
        // 语句using namespace绝不应当出现在头文件当中。
        void setName(const std::string &dogsName);

        void setWeight(int dogsWeight);

        // 如果一个函数不对对象的状态进行修改，
        // 应当在声明中加上const。
        // 这样，你就可以对一个以常量方式引用的对象执行该操作。
        // 同时可以注意到，当父类的成员函数需要被子类重写时，
        // 父类中的函数必须被显式声明为_虚函数（virtual）_。
        // 考虑到性能方面的因素，函数默认情况下不会被声明为虚函数。
        virtual void print() const;

        // 函数也可以在class body内部定义。
        // 这样定义的函数会自动成为内联函数。
        void bark() const
        {
            std::cout << name << " barks!\n";
        }

        // 除了构造器以外，C++还提供了析构器。
        // 当一个对象被删除或者脱离其定义域时，它的析构函数会被调用。
        // 这使得RAII这样的强大范式（参见下文）成为可能。
        // 为了衍生出子类来，基类的析构函数必须定义为虚函数。
        virtual ~Dog();

    }; // 在类的定义之后，要加一个分号
}