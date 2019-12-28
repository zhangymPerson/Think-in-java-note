# python 基础语法笔记

def choose_method(a, b):
    """
    python中的if语句
    python中没有switch语句
    只有 if: elif: else:
    判断语句
    :param a:
    :param b:
    :return:
    """
    if a > b:
        print("%d>%d" % (a, b))
    else:
        print("%d<=%d" % (a, b))
    if a > 0:
        print("%d>%d" % (a, 0))
    elif a < 0:
        print("%d<%d" % (a, 0))
    else:
        print("%d=%d" % (a, 0))


def loop_method():
    """
    循环写法

    for var in list :
        pass
    其中 var 表示list中的变量 list为数组或者集合
    :return:
    """
    for i in range(10):
        print(i)


def str_method():
    """
    python 中的字符串处理方式
    + 加号 和 java中的一致
    ""%(a,b) %s %d 等表示变量的占位符
    :return:
    """
    a = "aa"
    b = "bb"
    c = a + b
    print(c)
    print("a=%s,b=%s" % (a, b))


"""
主函数 脚本启动入口
"""
if __name__ == '__main__':
    # print属于基本打印函数
    print("基础语法")
    choose_method(-12, 14)
    str_method()
