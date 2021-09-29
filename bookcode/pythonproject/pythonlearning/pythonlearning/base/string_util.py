#!/usr/bin/python3


def test():
    a = "Hello"
    b = "Python"

    print("a + b 输出结果：= %s" % (a + b))
    print("a * 2 输出结果：= %s" % (a * 2))
    print("a[1] 输出结果：= %s" % (a[1]))
    print("a[1:4] 输出结果：= %s" % (a[1:4]))

    if("H" in a):
        print("H 在变量 a 中")
    else:
        print("H 不在变量 a 中")

    if("M" not in a):
        print("M 不在变量 a 中")
    else:
        print("M 在变量 a 中")

    print(r'\n')
    print(R'\n')


def run():
    print("hello world!")
    test()


if __name__ == '__main__':
    run()
