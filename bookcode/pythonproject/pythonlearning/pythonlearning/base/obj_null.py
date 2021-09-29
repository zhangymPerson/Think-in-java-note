#!/usr/bin/python3
# 各种非空判断


def stringNone(str):
    print("string 非空判断")
    if str is None:
        print("%s is None" % (str))
    else:
        print("%s is not None" % (str))

    if len(str) == 0:
        print("%s is 空字符串" % (str))
    else:
        print("%s is 非空字符串" % (str))


def run():
    print("hello world!")
    obj = ""
    obj = None
    # obj = "hello"
    if obj is None:
        print("obj is None")
        obj = "good"
    else:
        print("obj is not None")

    if obj == None:
        print("obj is None")
    else:
        print("obj is not None")


if __name__ == '__main__':
    
    run()
