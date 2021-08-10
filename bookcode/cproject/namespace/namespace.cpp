///////////
// 命名空间
///////////
#include <stdio.h>
// 命名空间为变量、函数和其他声明提供了分离的的作用域。
// 命名空间可以嵌套使用。

namespace First
{
    namespace Nested
    {
        void foo()
        {
            printf("This is First::Nested::foo\n");
        }
    } // 结束嵌套的命名空间Nested
} // 结束命名空间First

namespace Second
{
    void foo()
    {
        printf("This is Second::foo\n");
    }

    void goo()
    {
        printf("This is Second::goo\n");
    }
}

void foo()
{
    printf("This is global foo\n");
}

using namespace Second;
#include "one.h"
#include "two.h"
int main()
{
    // 如果没有特别指定，就从“Second”中取得所需的内容。
    goo();
    Second::foo();        // 显示“This is Second::foo”
    First::Nested::foo(); // 显示“This is First::Nested::foo”
    ::foo();              // 显示“This is global foo”
    using namespace two;
    fun();
    one::fun();
}