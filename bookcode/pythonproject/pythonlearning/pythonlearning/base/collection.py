#!/usr/bin/env python
# -*- encoding: utf-8 -*-
"""
@File    :   collection.py
@Contact :   zhangyanmingjiayou@163.com
python 中的集合 和 map简单使用
@Modify Time      @Author    @Version    @Desciption
------------      -------    --------    -----------
2019/12/7 10:41   danao      1.0         None
"""


def list_method():
    """
    python中的集合  数组
    python中的list是python的内置数据类型，
    list中的数据类不必相同的，
    array的中的类型必须全部相同。
    在list中的数据类型保存的是数据的存放的地址，简单的说就是指针，并非数据
    准确的来说，在python中是没有数组类型的，
    python中取而代之的是列表和元组。列表比元组好用，
    因为元组一旦定义就没法修改。而列表不仅可以和数组一样按索引访问，
    python中的set 和 Java中类似 set(["",""])创建
    :return:
    """
    # 列表
    names = ["zhangsna", "lisi", "wangwu", "zhaoliu"]
    # 当成list添加
    names.append(["append1", "append2"])
    # 追加list中每个元素
    names.extend(["extend1", "extend2"])
    names.append(None)
    names.append({"a", "b", "c"})
    names.insert(-1, "aaaaaaaaaaaaa")
    print("names = %s" % (names))

    # list 测试
    attrs = list()
    attrs.append("a")
    attrs.append(0)
    attrs.append(None)
    attrs.append(names)
    attrs.append("")
    print("attrs = %s" % (attrs))

    """
    python中的无序集合
    """
    # 无序的集合对象
    s = {"a", "b", "a", "b", "c"}
    print("s = %s" % (s))
    s = set({"a", "b", "a", "b", "c"})
    print("s = %s" % (s))
    s = {"a", "a", "b", "c"}
    print("s = %s" % (s))


def map_method():
    """
    python中map对象
    python中的字典，相当于Java中的map集合，
    存储的是键值对数据。用“{}”进行定义。
    :return:
    """
    # 字典存储无序的数据
    name_map = {"name": "ljf", "age": 18, "price": 2.5}
    print(name_map)
    # 查询
    print(name_map["name"])
    # 修改
    name_map["age"] = 19
    print(name_map)
    # 添加
    name_map["adress"] = "beijing"
    print(name_map)
    # 删除
    name_map.pop("adress")
    print(name_map)
    # 统计字符串个数
    print(len(name_map))
    # 合并字典,合并时已经存在某个键值对，后者覆盖前者
    temp_map = {"address": "背景"}
    name_map.update(temp_map)
    print(name_map)
    # 遍历
    for m in name_map:
        print("遍历:%s" % {m, name_map[m]})
    # 列表中存储字典，列表中存储多个字典
    name_list = [{"name": "beijing", "adCode": 110100}, {"name": "tianjing", "adCode": 234000},
                 {"name": "shanghai", "adCode": 45600}]
    for k in name_list:
        print(k)


if __name__ == '__main__':
    print("python中的集合")
    list_method()
    map_method()
