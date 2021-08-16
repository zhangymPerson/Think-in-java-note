#include <iostream>
using namespace std;

// 函数
int add(int a, int b)
{
    return a + b;
}

// 函数的声明
int max(int a, int b);
// 可以声明多次
int max(int a, int b);

int main()
{
    cout << "测试" << endl;
    cout << "add 3,4" << add(3, 4) << endl;
    cout << "max = " << max(100, 233) << endl;
}

// 声明后的函数可以放到main之后
// 不声明的函数
int max(int a, int b)
{
    return a > b ? a : b;
}
