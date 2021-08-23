#include <iostream>
#include "person.h"
#include <sstream>
using namespace std;
namespace danao
{

    // 构造函数
    Person::Person()
    {
        std::cout << "构造函数" << std::endl;
    };

    Person::Person(int _age, std::string _name, int _id)
    {
        age = _age;
        name = _name;
        id = _id;
    }

    // 析构函数
    Person::~Person()
    {
        std::cout << "析构函数" << std::endl;
    }

    /**
     * get/set 
     */
    void Person::setAge(int age)
    {
        if (age < 0 || age > 150)
        {
            std::cout << age << "不合法";
        }
        this->age = age;
    }

    int Person::getAge()
    {
        return age;
    }

    void Person::setName(std::string name)
    {
        this->name = name;
    }

    std::string Person::getName()
    {
        return name;
    }

    void Person::setId(int id)
    {
        if (id < 0)
        {
            std::cout << "id 不合法";
        }
        this->id = id;
    }

    int Person::getId()
    {
        return id;
    }

    /**
     * toString()
     */
    std::string Person::toString()
    {
        ostringstream os;
        os << "Person is" << id << ",name is" << name << ", age = " << age
           << ";" << std::endl;
        return os.str();
    }

}