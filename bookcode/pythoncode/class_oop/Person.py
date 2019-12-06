# python中面向对象
# 类是由 方法(函数) 变量 属性 组成的集合
# class本身不创建对象
# 每一个Python类都隐含了一个超类：object。

"""
Python中的面向对象
__init__并不相当于C#中的构造函数，执行它的时候，实例已构造出来了。
可以理解为两步：
a=object.__new__(A)
A.__init__(a,'hello')

父子类 __init__
子类可以不重写__init__，实例化子类时，会自动调用超类中已定义的__init__
如果重写了__init__，实例化子类时，则不会隐式的再去调用超类中已定义的__init__

"""


class Person(object):

    def __init__(self, id, name, remark, age):
        """
        __init__ 被称为构造器 但与java不完全一致
        :param id:
        :param name:
        :param remark:
        :param age:
        """
        super().__init__()
        self.id = id
        self.name = name
        self.remark = remark
        self.age = age

    def __privatetest(self):
        """
        私有函数 方法
        函数名 __ 开头的为私有函数
        类似Java中private void toString(){}
        :return:
        """
        print("private method test", self.id)

    def publictest(self):
        """
        共有函数 方法
        :return:
        """
        print("public method test", self.id)


"""
python 一个文件有多个class
Son继承了Person
"""


class Son(Person):
    """
    构造方法
    """

    def __init__(self, son_id):
        self.son_id = son_id


class SonS(Person):

    def __init__(self, id, name, remark, age, ssid):
        super.__init__(id, name, remark, age)
        self.ssid = ssid


"""
主函数进行测试
"""
if __name__ == '__main__':
    """
    创建对象
    """
    p = Person("pid", "pname", "premark", 13)
    # 以下构造是错误的
    # ps = Person.__init__(p,"pids","pnames","remarks",14)
    print(p.id)
    # print(ps.id)
    # 只能调用公有函数 不能调用私有函数
    p.publictest()
    # 查看类属性  <class '__main__.Person'>
    print(p.__class__)
    s = Son("sid")
    print(s.son_id)
