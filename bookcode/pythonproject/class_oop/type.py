#!/usr/bin/python3
# _*_encoding:utf-8_*_
"""
类型查看和判断
类型判断
"""


def run():
    """
    自定义的实现逻辑和代码
    :return:
    """
    print("start")
    # 判断变量是否为整数
    money = 120
    print("{0}是{1}".format(money, getType(money)))
    print("python 原生判断 {0}是{1}".format(money, type(money)))

    # 判断变量是否为字符串
    money = "120"
    print("{0}是{1}".format(money, getType(money)))
    print("python 原生判断 {0}是{1}".format(money, type(money)))

    money = 12.3
    print("{0}是{1}".format(money, getType(money)))
    print("python 原生判断 {0}是{1}".format(money, type(money)))

    # 判断变量是否为列表
    students = ['studentA']
    print("{0}是{1}".format(students, getType(students)))
    print("python 原生判断 {0}是{1}".format(students, type(students)))

    # 判断变量是否为元组
    students = ('studentA', 'studentB')
    print("{0}是{1}".format(students, getType(students)))
    print("python 原生判断 {0}是{1}".format(students, type(students)))

    # 判断变量是否为字典
    dictory = {"key1": "value1", "key2": "value2"}
    print("{0}是{1}".format(dictory, getType(dictory)))
    print("python 原生判断 {0}是{1}".format(dictory, type(dictory)))

    # 判断变量是否为集合
    apple = {"apple1", "apple2"}
    print("{0}是{1}".format(apple, getType(apple)))
    print("python 原生判断 {0}是{1}".format(apple, type(apple)))


def typeof(variate):
    """
    判断变量类型的函数
    """
    type = None
    if isinstance(variate, int):
        type = "int"
    elif isinstance(variate, str):
        type = "str"
    elif isinstance(variate, float):
        type = "float"
    elif isinstance(variate, list):
        type = "list"
    elif isinstance(variate, tuple):
        type = "tuple"
    elif isinstance(variate, dict):
        type = "dict"
    elif isinstance(variate, set):
        type = "set"
    return type


def getType(variate):
    """
    判断变量类型的函数
    """
    arr = {"int": "整数", "float": "浮点", "str": "字符串",
           "list": "列表", "tuple": "元组", "dict": "字典", "set": "集合"}
    vartype = typeof(variate)
    if not (vartype in arr):
        return "未知类型"
    return arr[vartype]


def main():
    run()


if __name__ == '__main__':
    main()
