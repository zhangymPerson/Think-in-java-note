// 测试下 #if
// 看一下应用格式：
// #if 表达式
// 如果表达式为真程序段1
// #else
// 否则程序段2
// #endif
// 在程序中，应用比较多的#if 1或是#if 0，后面加#endif

#if 0
#include <iostream>
using std::cout;
int main() {
    cout << "        *" << '\n';
    cout << "      *   *" << '\n';
    cout << "    *   *   *" << '\n';
    cout << "  *   *   *   *" << '\n';
    return 0;
}
#endif

#if 0
#include <iostream>
//用#define定义宏
#define PI 3.1415 //宏定义
int main()
{
    std::cout << PI * 2.5 * 2.5 << std::endl;
    std::cout << 2 * PI * 2.5 << std::endl;
    return 0;
}
#endif

#if 0
// 5. typeid
// typeid运算符查询得到一个数据类型或变量的类型信息
#include <iostream>
int main()
{
    auto b = true;
    auto ch{'x'};
    auto i = 123;
    auto j = 123L;
    auto d{1.2};
    auto z = d + i;

    std::cout << b << " " << ch << " " << i << " " << j << " "
              << d << " " << z << '\n';

    std::cout << typeid(b).name() << " " << typeid(ch).name() << " "
              << typeid(int).name() << " " << typeid(j).name() << " "
              << typeid(d).name() << " " << typeid(z).name() << '\n';
    return 0;
}
#endif

#if 0
// 2.类型决定了变量占据内存的大小
#include <iostream>
int main()
{
    int i = 3;
    char ch = 'A';
    double radius = 2.56;
    bool ok = false;

    std::cout << "int整型占用内存： " << sizeof(int) << "字节" << std::endl;
    std::cout << "i占用内存： " << sizeof(i) << "字节" << std::endl;
    std::cout << "ch占用内存： " << sizeof(ch) << "字节" << std::endl;
    std::cout << "radius占用内存： " << sizeof(radius) << "字节" << std::endl;
    std::cout << "ok占用内存： " << sizeof(ok) << "字节" << std::endl;
}
#endif

// -----------3.1 运算符------------
//按功能的不同，可分为：算术、比较、逻辑、位运算、赋值等
//算术：+、-、*、/、%（求余数）、++（自增）、--（自减）
//比较：==、!=、>、<、>=、<=
//逻辑：&&（逻辑与）、||（逻辑或）、 ！（逻辑非）
//位运算：&（与）、|（或）、^(异或)、~（补）、<<（左移）、>>（右移）
//赋值：=、+=、*=、|=、...

// 按运算数个数，可分为：一元、二元、三元
#if 1
#include <iostream>
int main()
{
    int a, b, c;
    std::cout << "请输入3个数字" << std::endl;
    std::cin >> a >> b >> c;
    int min = a < b ? (a < c ? a : c) : (b < c ? b : c);
    std::cout << a << "," << b << "," << c << "这3个数的最小值是："
              << min << std::endl;
}
#endif